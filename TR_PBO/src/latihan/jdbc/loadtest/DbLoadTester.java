package latihan.jdbc.loadtest;

import java.sql.*;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**
 * NetBeans-ready DbLoadTester
 *
 * Place in: src/latihan/jdbc/loadtest/DbLoadTester.java
 * Package: latihan.jdbc.loadtest
 *
 * Usage (Run File in NetBeans or run from CLI):
 *   --dbUrl=jdbc:mysql://127.0.0.1:3306/dbabsen
 *   --dbUser=root
 *   --dbPass=
 *   --threads=20
 *   --duration=60
 *   --readRatio=100   (0-100, percent reads; default 100 = read-only)
 *   --table=tbabsen
 *   --maxId=500       (max id value to sample for selects)
 *
 * Example:
 *   java -cp .:mysql-connector-java-8.0.xx.jar latihan.jdbc.loadtest.DbLoadTester \
 *       --dbUrl=jdbc:mysql://127.0.0.1:3306/dbabsen --dbUser=root --dbPass= --threads=20 --duration=60 --readRatio=80 --table=tbabsen --maxId=500
 *
 * Notes:
 * - Default behaviour is non-destructive (read-only). To enable writes, set readRatio < 100.
 * - The program will inspect the target table's columns and attempt to choose suitable columns for INSERT.
 *   If it cannot find suitable writable columns, it will skip inserts and run read-only load.
 */
public class DbLoadTester {

    static class Config {
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/dbabsen";
        String dbUser = "root";
        String dbPass = "";
        int threads = 10;
        int durationSec = 60;
        int readRatio = 100; // percent
        String table = "tbabsen";
        int maxId = 500;
        boolean autocommit = true;
    }

    static Config cfg = new Config();

    static AtomicLong totalOps = new AtomicLong();
    static AtomicLong totalErrors = new AtomicLong();
    static ConcurrentLinkedQueue<Long> latenciesNs = new ConcurrentLinkedQueue<>();
    static volatile boolean stop = false;

    public static void main(String[] args) throws Exception {
        parseArgs(args);

        System.out.println("=== DbLoadTester ===");
        System.out.printf("DB URL: %s%nUser: %s%nTable: %s%nThreads: %d  Duration: %ds  readRatio: %d%%%n",
                cfg.dbUrl, cfg.dbUser, cfg.table, cfg.threads, cfg.durationSec, cfg.readRatio);

        // Try a quick connection to validate DB access and collect table metadata
        TableSpec spec = null;
        try (Connection c = DriverManager.getConnection(cfg.dbUrl, cfg.dbUser, cfg.dbPass)) {
            c.setAutoCommit(true);
            spec = inspectTable(c, cfg.table);
            if (spec == null) {
                System.err.println("ERROR: could not find table '" + cfg.table + "' or no usable columns. Exiting.");
                return;
            }
            System.out.println("Discovered table: " + cfg.table + " -> columns: " + spec.columnNames);
            if (!spec.canWrite) {
                System.out.println("Warning: table does not expose writable columns suitable for INSERT; tester will run read-only.");
            } else {
                System.out.println("Insert template: " + spec.insertSql);
            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e.getMessage());
            return;
        }

        ExecutorService exec = Executors.newFixedThreadPool(cfg.threads);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> stop = true, cfg.durationSec, TimeUnit.SECONDS);

        List<Future<?>> futures = new ArrayList<>();
        for (int i=0;i<cfg.threads;i++) {
            futures.add(exec.submit(new Worker(i, spec)));
        }

        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (ExecutionException ee) {
                System.err.println("Worker exception: " + ee.getCause());
            }
        }

        exec.shutdown();
        scheduler.shutdownNow();

        printSummary();
    }

    static void parseArgs(String[] args) {
        for (String a : args) {
            if (!a.startsWith("--")) continue;
            String[] parts = a.substring(2).split("=", 2);
            String k = parts[0], v = parts.length>1 ? parts[1] : "";
            switch (k) {
                case "dbUrl": cfg.dbUrl = v; break;
                case "dbUser": cfg.dbUser = v; break;
                case "dbPass": cfg.dbPass = v; break;
                case "threads": cfg.threads = Integer.parseInt(v); break;
                case "duration": case "durationSec": cfg.durationSec = Integer.parseInt(v); break;
                case "readRatio": cfg.readRatio = Integer.parseInt(v); break;
                case "table": cfg.table = v; break;
                case "maxId": cfg.maxId = Integer.parseInt(v); break;
                case "autocommit": cfg.autocommit = Boolean.parseBoolean(v); break;
                default:
                    System.err.println("Unknown arg: " + k);
            }
        }
    }

    static class TableSpec {
        String tableName;
        List<String> columnNames = new ArrayList<>();
        boolean canWrite = false;
        String insertSql = null;
        List<String> insertColumns = new ArrayList<>();
    }

    static TableSpec inspectTable(Connection conn, String table) {
        try {
            DatabaseMetaData md = conn.getMetaData();
            String catalog = conn.getCatalog();
            ResultSet cols = md.getColumns(catalog, null, table, null);
            TableSpec spec = new TableSpec();
            spec.tableName = table;
            List<ColumnInfo> info = new ArrayList<>();
            while (cols.next()) {
                String colName = cols.getString("COLUMN_NAME");
                String typeName = cols.getString("TYPE_NAME"); // e.g., VARCHAR, INT, DATETIME
                int nullable = cols.getInt("NULLABLE");
                info.add(new ColumnInfo(colName, typeName, nullable==DatabaseMetaData.columnNullable));
                spec.columnNames.add(colName);
            }
            cols.close();
            if (info.isEmpty()) {
                System.err.println("Table '" + table + "' not found or has no columns.");
                return null;
            }
            // Pick candidate columns:
            // - for "name" pick first VARCHAR/CHAR/TEXT
            // - for "date" pick TIMESTAMP/DATETIME/DATE
            List<String> nameCols = new ArrayList<>();
            List<String> dateCols = new ArrayList<>();
            List<String> otherWritable = new ArrayList<>();
            for (ColumnInfo ci : info) {
                String t = ci.typeName.toUpperCase();
                if (t.contains("CHAR") || t.contains("TEXT")) nameCols.add(ci.name);
                if (t.contains("DATE") || t.contains("TIME") || t.contains("TIMESTAMP")) dateCols.add(ci.name);
                // Exclude obvious auto-increment primary keys: we don't detect PK here, so be conservative: allow non-ID columns
                if (!(t.contains("INT") && ci.name.toLowerCase().matches("id|no|idx|pk|count"))) {
                    otherWritable.add(ci.name);
                }
            }
            // Build insert template prefering (name,date,other)
            List<String> chosen = new ArrayList<>();
            if (!nameCols.isEmpty()) chosen.add(nameCols.get(0));
            if (!dateCols.isEmpty()) chosen.add(dateCols.get(0));
            // add one more text or numeric column if available
            for (String c : otherWritable) {
                if (!chosen.contains(c)) { chosen.add(c); break; }
            }
            if (!chosen.isEmpty()) {
                spec.canWrite = true;
                spec.insertColumns = chosen;
                String colsJoined = String.join(", ", chosen);
                String placeholders = String.join(", ", Collections.nCopies(chosen.size(), "?"));
                spec.insertSql = "INSERT INTO " + table + " (" + colsJoined + ") VALUES (" + placeholders + ")";
            } else {
                spec.canWrite = false;
            }
            return spec;
        } catch (SQLException e) {
            System.err.println("Error inspecting table: " + e.getMessage());
            return null;
        }
    }

    static class ColumnInfo {
        String name;
        String typeName;
        boolean nullable;
        ColumnInfo(String n, String t, boolean nullable) { this.name=n; this.typeName=t; this.nullable=nullable; }
    }

    static class Worker implements Runnable {
        int id;
        Random rnd = new Random();
        TableSpec spec;

        Worker(int id, TableSpec spec) { this.id = id; this.spec = spec; }

        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(cfg.dbUrl, cfg.dbUser, cfg.dbPass)) {
                conn.setAutoCommit(cfg.autocommit);
                PreparedStatement selStmt = conn.prepareStatement(makeSelectSql(cfg.table));
                PreparedStatement insStmt = null;
                if (spec != null && spec.canWrite && cfg.readRatio < 100) {
                    insStmt = conn.prepareStatement(spec.insertSql);
                }

                while (!stop) {
                    boolean isRead = (rnd.nextInt(100) < cfg.readRatio);
                    long start = System.nanoTime();
                    try {
                        if (isRead) {
                            int randId = Math.max(1, rnd.nextInt(Math.max(1, cfg.maxId)) + 1);
                            selStmt.setInt(1, randId);
                            try (ResultSet rs = selStmt.executeQuery()) {
                                while (rs.next()) { /* consume */ }
                            }
                        } else {
                            if (insStmt == null) {
                                // fallback to select if we couldn't prepare insert
                                int randId = Math.max(1, rnd.nextInt(Math.max(1, cfg.maxId)) + 1);
                                selStmt.setInt(1, randId);
                                try (ResultSet rs = selStmt.executeQuery()) { while (rs.next()){} }
                            } else {
                                // populate insert placeholders heuristically
                                int idx = 1;
                                for (String col : spec.insertColumns) {
                                    // pick a value based on column name
                                    String low = col.toLowerCase();
                                    if (low.contains("name") || low.contains("nama") || low.contains("user")) {
                                        insStmt.setString(idx++, "load_" + rnd.nextInt(1_000_000));
                                    } else if (low.contains("date") || low.contains("time") || low.contains("tanggal")) {
                                        insStmt.setTimestamp(idx++, new Timestamp(System.currentTimeMillis()));
                                    } else {
                                        // generic fallback: string
                                        insStmt.setString(idx++, "val_" + rnd.nextInt(1_000_000));
                                    }
                                }
                                insStmt.executeUpdate();
                                if (!cfg.autocommit) conn.commit();
                            }
                        }
                        long elapsed = System.nanoTime() - start;
                        latenciesNs.add(elapsed);
                        totalOps.incrementAndGet();
                    } catch (SQLException sqe) {
                        totalErrors.incrementAndGet();
                        long elapsed = System.nanoTime() - start;
                        latenciesNs.add(elapsed);
                        if (totalErrors.get() % 100 == 1) {
                            System.err.println("Worker " + id + " SQL error: " + sqe.getMessage());
                        }
                        // small backoff
                        Thread.sleep(10);
                    }
                }

                selStmt.close();
                if (insStmt != null) insStmt.close();

            } catch (Exception e) {
                totalErrors.incrementAndGet();
                System.err.println("Worker " + id + " fatal: " + e.getMessage());
            }
        }

        private String makeSelectSql(String table) {
            // We assume a numeric primary-like column named 'no' or 'id' for sampling.
            // If your table uses another column, adjust --maxId accordingly or change to a different WHERE.
            if (table != null && (table.toLowerCase().contains("absen") || table.toLowerCase().contains("karyawan"))) {
                // common pattern in your project: tbabsen (no)
                return "SELECT * FROM " + table + " WHERE no = ?";
            } else {
                return "SELECT * FROM " + table + " WHERE id = ?";
            }
        }
    }

    static void printSummary() {
        long ops = totalOps.get();
        long errs = totalErrors.get();
        List<Long> latList = new ArrayList<>(latenciesNs.size());
        for (Long n : latenciesNs) latList.add(n);
        Collections.sort(latList);
        double avgMs = latList.stream().mapToLong(Long::longValue).average().orElse(0.0) / 1_000_000.0;
        double p50 = percentile(latList, 50) / 1_000_000.0;
        double p90 = percentile(latList, 90) / 1_000_000.0;
        double p95 = percentile(latList, 95) / 1_000_000.0;
        double p99 = percentile(latList, 99) / 1_000_000.0;

        System.out.println("\n=== TEST SUMMARY ===");
        System.out.printf("Duration (s): %d%n", cfg.durationSec);
        System.out.printf("Threads: %d%n", cfg.threads);
        System.out.printf("Total ops (successful + failed): %d%n", ops + errs);
        System.out.printf("Successes: %d, Errors: %d%n", ops, errs);
        double opsPerSec = (ops + errs) / (double) Math.max(1, cfg.durationSec);
        System.out.printf("Throughput (ops/sec): %.2f%n", opsPerSec);
        System.out.printf("Avg latency (ms): %.3f%n", avgMs);
        System.out.printf("p50/p90/p95/p99 (ms): %.3f / %.3f / %.3f / %.3f%n", p50, p90, p95, p99);
        System.out.println("====================");
    }

    static long percentile(List<Long> sortedNs, double p) {
        if (sortedNs.isEmpty()) return 0L;
        int idx = (int) Math.ceil((p / 100.0) * sortedNs.size()) - 1;
        idx = Math.max(0, Math.min(idx, sortedNs.size()-1));
        return sortedNs.get(idx);
    }
}