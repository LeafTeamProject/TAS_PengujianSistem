package latihan.jdbc.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;


public class UserController {
    Statement stat;
    ResultSet res;
    String sql;
    DefaultTableModel dtm = new DefaultTableModel();

    public UserController() {
        Koneksi db = new Koneksi();
        db.config();
        stat = db.stm;
    }

    public DefaultTableModel createTable() {
        dtm.addColumn("Hari Absen");
        dtm.addColumn("Status");
        return this.dtm;
    }

    public void tampilkanUser(String nama) {
    try {
        dtm.getDataVector().removeAllElements();
        dtm.fireTableDataChanged();

        // Perhatikan penggunaan backtick (`) di sekitar nama kolom
        this.sql = "SELECT keterangan, tanggal FROM tbabsen WHERE nama = '"+nama+"'";
        res = stat.executeQuery(sql);

        while (res.next()) {
            Object[] obj = new Object[2];
            obj[0] = res.getString("tanggal");
            obj[1] = res.getString("keterangan"); 
            dtm.addRow(obj);
        }
    } catch (Exception e) {
        System.out.println("Query Gagal: " + e.getMessage());
    }
}


    public boolean tambahUser(String nama, String status ,String hariAbsen) {
        System.out.println();
    try {
        // Mengecek jika hariAbsen kosong atau null
        if (hariAbsen == null || hariAbsen.isEmpty()) {
            System.out.println("Tanggal tidak valid");
            return false; // Jika tanggal tidak dipilih, return false
        }

        // Menggunakan SimpleDateFormat untuk memastikan format tanggal valid (yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Mengonversi string hariAbsen menjadi Date
        java.util.Date date = dateFormat.parse(hariAbsen);
        String formattedDate = dateFormat.format(date); // Mengonversi tanggal menjadi string dalam format yang sesuai

        // Query SQL untuk insert data dengan memastikan kolom Password disertakan
        this.sql = "INSERT INTO tbabsen (nama, tanggal, keterangan) VALUES ('" + nama + "', '" + formattedDate + "','" + status + "')";

        // Menjalankan query
        this.stat.executeUpdate(sql);
        return true;
    } catch (Exception e) {
        System.out.println("Insert Gagal: " + e.getMessage());
        return false;
    }
}



public boolean ubahUser(int id, String nama, String hariAbsen) {
    try {
        // Mengecek jika hariAbsen adalah null atau kosong
        if (hariAbsen == null || hariAbsen.isEmpty()) {
            System.out.println("Tanggal tidak dipilih");
            return false; // Jika tanggal tidak dipilih, return false
        }

        // Menggunakan SimpleDateFormat untuk memastikan format tanggal valid (yyyy-MM-dd)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Memeriksa apakah tanggal yang diterima valid
        java.util.Date date = dateFormat.parse(hariAbsen);
        String formattedDate = dateFormat.format(date); // Mengonversi tanggal menjadi string dalam format yang sesuai

        // Query SQL untuk update data
        this.sql = "UPDATE tbuser SET Nama='" + nama + "', " +
                   "`Hari Absen`='" + formattedDate + "' WHERE Id=" + id;
        
        // Menjalankan query
        this.stat.executeUpdate(sql);
        return true;
    } catch (Exception e) {
        System.out.println("Update Gagal: " + e.getMessage());
        return false;
    }
}




    public boolean hapusUser(int id) {
        try {
            this.sql = "DELETE FROM tbuser WHERE Id=" + id;
            this.stat.executeLargeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Delete Gagal: " + e.getMessage());
            return false;
        }
    }
}
