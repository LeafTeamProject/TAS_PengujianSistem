package latihan.jdbc.controller;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.*;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Tests for LoginController:
 * - invalid admin login (wrong password)
 * - invalid admin login (wrong status)
 * - karyawan login success
 * - karyawan login wrong password
 *
 * The class inserts temporary rows into tbadmin and tbkaryawan using only columns
 * that exist in those tables, then calls the corresponding LoginController methods.
 * Rows are deleted in tearDown.
 */
public class LoginControllerNegativeAndKaryawanTest {

    // DB connection (matches Koneksi.java default)
    private static final String DB_URL  = "jdbc:mysql://localhost/dbabsen";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    // test identities (unique per run)
    private String adminName;
    private String adminPass;
    private String adminStatus;

    private String karName;
    private String karPass;
    private String karStatus;

    private Connection conn;

    @Before
    public void setUp() throws Exception {
        try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch (ClassNotFoundException ignore) {}

        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        conn.setAutoCommit(true);

        long uniq = Instant.now().toEpochMilli() % 1000000L;

        adminName = "junit_admin_" + uniq;
        adminPass = "jpass_" + uniq;
        adminStatus = "admin"; // adjust if your app expects different status string

        karName = "junit_karyawan_" + uniq;
        karPass = "kpass_" + uniq;
        karStatus = "aktif"; // default status for karyawan; adjust if your schema uses another value

        // Insert admin row
        insertRowWithPreferredCols(conn, "tbadmin", buildMapForAdmin(adminName, adminPass, adminStatus));

        // Insert karyawan row
        insertRowWithPreferredCols(conn, "tbkaryawan", buildMapForKaryawan(karName, karPass, karStatus));
    }

    @After
    public void tearDown() throws Exception {
        if (conn != null) {
            // cleanup admin by nama if exists
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tbadmin WHERE nama = ?")) {
                ps.setString(1, adminName);
                ps.executeUpdate();
            } catch (SQLException ignore) {}

            // cleanup karyawan by nama if exists
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM tbkaryawan WHERE nama = ?")) {
                ps.setString(1, karName);
                ps.executeUpdate();
            } catch (SQLException ignore) {}

            try { conn.close(); } catch (Exception ignore) {}
        }
    }

    // ---------------- TESTS ----------------

    @Test
    public void testAdminLoginWrongPassword() {
        LoginController ctrl = new LoginController();
        boolean ok = ctrl.cekLogin(adminName, adminPass + "_wrong", adminStatus);
        assertFalse("Admin login should fail with wrong password", ok);
    }

    @Test
    public void testAdminLoginWrongStatus() {
        LoginController ctrl = new LoginController();
        boolean ok = ctrl.cekLogin(adminName, adminPass, "not_a_status");
        assertFalse("Admin login should fail with wrong status", ok);
    }

    @Test
    public void testKaryawanLoginSuccess() {
        LoginController ctrl = new LoginController();
        boolean ok = ctrl.cekLoginKaryawan(karName, karPass, karStatus);
        assertTrue("Karyawan login should succeed for seeded credentials", ok);
    }

    @Test
    public void testKaryawanLoginWrongPassword() {
        LoginController ctrl = new LoginController();
        boolean ok = ctrl.cekLoginKaryawan(karName, karPass + "_bad", karStatus);
        assertFalse("Karyawan login should fail with wrong password", ok);
    }

    // ---------------- Helpers ----------------

    /** Build a candidate value map for tbadmin insertion */
    private Map<String, String> buildMapForAdmin(String nama, String pass, String status) {
        Map<String,String> m = new HashMap<>();
        m.put("nama", nama);
        m.put("password", pass);
        m.put("status", status);
        m.put("hp", "000");
        m.put("kelamin", "M");
        m.put("jabaran", "tester");
        return m;
    }

    /** Build a candidate map for tbkaryawan insertion */
    private Map<String, String> buildMapForKaryawan(String nama, String pass, String status) {
        Map<String,String> m = new HashMap<>();
        m.put("nama", nama);
        m.put("password", pass);
        m.put("status", status);
        m.put("telepon", "000");
        m.put("kelamin", "M");
        m.put("jabatan", "staff");
        return m;
    }

    /**
     * Insert a row into tableName using only the preferred columns that actually exist.
     * preferredValues maps column -> value candidates.
     */
    private void insertRowWithPreferredCols(Connection c, String tableName, Map<String,String> preferredValues) throws SQLException {
        Set<String> existing = getTableColumns(c, tableName);
        if (existing.isEmpty()) throw new SQLException("Table " + tableName + " not found or has no columns.");

        List<String> useCols = preferredValues.keySet().stream()
                .map(String::toLowerCase)
                .filter(existing::contains)
                .collect(Collectors.toList());

        if (useCols.isEmpty()) {
            // fallback: pick first non-id column(s)
            useCols = pickFallbackColumns(c, tableName);
            if (useCols.isEmpty()) throw new SQLException("No suitable columns found for table " + tableName);
        }

        String colList = String.join(", ", useCols);
        String qs = useCols.stream().map(x -> "?").collect(Collectors.joining(", "));
        String insertSql = "INSERT INTO " + tableName + " (" + colList + ") VALUES (" + qs + ")";
        try (PreparedStatement ps = c.prepareStatement(insertSql)) {
            for (int i = 0; i < useCols.size(); i++) {
                String col = useCols.get(i).toLowerCase();
                String val = preferredValues.getOrDefault(col, "val_" + System.currentTimeMillis());
                ps.setString(i+1, val);
            }
            ps.executeUpdate();
        }
    }

    /** Return lower-case column name set for the table */
    private Set<String> getTableColumns(Connection c, String tableName) throws SQLException {
        Set<String> cols = new HashSet<>();
        DatabaseMetaData md = c.getMetaData();
        try (ResultSet rs = md.getColumns(c.getCatalog(), null, tableName, null)) {
            while (rs.next()) {
                String col = rs.getString("COLUMN_NAME");
                if (col != null) cols.add(col.toLowerCase());
            }
        }
        return cols;
    }

    /** Choose fallback columns if no preferred columns matched */
    private List<String> pickFallbackColumns(Connection c, String tableName) throws SQLException {
        List<String> result = new ArrayList<>();
        DatabaseMetaData md = c.getMetaData();
        try (ResultSet rs = md.getColumns(c.getCatalog(), null, tableName, null)) {
            while (rs.next() && result.size() < 3) {
                String col = rs.getString("COLUMN_NAME");
                String colLower = (col==null) ? "" : col.toLowerCase();
                if (colLower.equals("id") || colLower.equals("no")) continue;
                result.add(colLower);
            }
        }
        return result;
    }
}