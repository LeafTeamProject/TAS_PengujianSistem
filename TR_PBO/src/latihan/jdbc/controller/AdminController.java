package latihan.jdbc.controller;

import latihan.jdbc.model.Karyawan;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminController {
    Statement stat;
    ResultSet res;
    String sql;
    //membuat model table (kolom2nya)
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtm2 = new DefaultTableModel();
    public AdminController(){
        Koneksi db = new Koneksi();
        db.config();
        stat = db.stm;
    }
    
    //bikin table versi DATA KARYAWAN
    public DefaultTableModel createTable(){
        dtm.addColumn("ID");
        dtm.addColumn("Nama Karyawan");
        dtm.addColumn("Nomor hp");
        dtm.addColumn("Kelamin");
        dtm.addColumn("Jabatan");
        
        return this.dtm;
    }
    //bantu bikin table versi DATA ASBSEN
    public DefaultTableModel Absen(){
        dtm2.addColumn("Nomor");
        dtm2.addColumn("Nama");
        dtm2.addColumn("Tanggal");
        dtm2.addColumn("Keterangan");
        return this.dtm2;
    }
    
    //SELECT TAMPILKAN DATA KARYAWAN
    public void tampilkanKaryawan(){
        try {
            //Clear dtm/ table sementaranya
            dtm.getDataVector().removeAllElements();
            dtm.fireTableDataChanged();
            
            sql = "SELECT id, nama, hp, kelamin, jabatan FROM tblistkaryawan";
            
            res = stat.executeQuery(sql);
            
            //hasil query ditampilkna di dtm
            while(res.next()){
                Object[] obj = new Object[5];
                //get string harus sama dengan kolom di db
                obj[0] = res.getString("id");
                obj[1] = res.getString("nama");
                obj[2] = res.getString("hp");
                obj[3] = res.getString("kelamin");
                obj[4] = res.getString("jabatan");
                dtm.addRow(obj);
                
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    //langsung buat table kyk yg diatas tp langsung nampilin langusng isinya tbabsen
    public DefaultTableModel tampilAbsensi() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nomor");
        dtm.addColumn("Nama");
        dtm.addColumn("Tanggal");
        dtm.addColumn("Keterangan");

        try {
            String sql = "SELECT * FROM tbabsen";
            res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] obj = new Object[4];
                obj[0] = res.getString("no");
                obj[1] = res.getString("nama");
                obj[2] = res.getString("tanggal");
                obj[3] = res.getString("keterangan");
                dtm.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return dtm;
    }

    // ini buat tambah karyawan di tblistkaryawan (DATA KARYAWAN)
    public boolean tambahKaryawan(String a, String b, String c, String d){
        try {
            Karyawan ky = new Karyawan();
            ky.setNama(a);
            ky.setHp(b);
            ky.setKelamin(c);
            ky.setJabatan(d);
            
            sql = "INSERT INTO tblistkaryawan (nama, hp, kelamin, jabatan) VALUES ('"
                + ky.getNama() + "', '"
                + ky.getHp() + "', '"
                + ky.getKelamin() + "', '"
                + ky.getJabatan() + "')";
            
            stat.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
            
    // ini method buat di bagian nyari bulan berapa di absen buat di cari
    public void cariBulan(String bulan){
        try {
            dtm2.getDataVector().removeAllElements();
            dtm2.fireTableDataChanged();
            Karyawan k = new Karyawan();
            k.setBulan(bulan);

            sql = "SELECT * FROM tbabsen WHERE MONTH(tanggal)="+k.getBulan()+"";

            res = stat.executeQuery(sql);
            //buat masukin nilai ke kolomnya biar bisa ditampilin
            while (res.next()) {
                Object[] obj = new Object[4];
                obj[0] = res.getString("no");
                obj[1] = res.getString("nama");
                obj[2] = res.getDate("tanggal");
                obj[3] = res.getString("keterangan");

                dtm2.addRow(obj);
            }

        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error saat mencari data!");
        }
    }
    
    //buat ngedit di bagian absen dari nama, tanggal, dan keterangan
    public boolean ubahAbsen(int id, String nama,String tg, String Ket){
        Karyawan k = new Karyawan();
        k.setId(id);
        k.setNama(nama);
        k.setTanggal(tg);
        k.setKeterangan(Ket);
            
        try {
            this.sql= "UPDATE tbabsen SET nama = '" + k.getNama() + "', tanggal= '"+ k.getTanggal()+"',keterangan = '" + k.getKeterangan() + "' WHERE no = " + k.getId();
            stat.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // ngedit di DATA KARYAWAN buat ngubah informasinya
    public boolean ubahKaryawan(int a, String b, String c,String d, String f){
        Karyawan ns = new Karyawan();
        ns.setId(a);
        ns.setNama(b);
        ns.setHp(c);
        ns.setKelamin(d);
        ns.setJabatan(f);
        
        
        try {
            //query
            this.sql = "UPDATE tblistkaryawan SET nama = '" + ns.getNama() + "', " +
                       "hp = '" + ns.getHp() + "', " +
                       "kelamin = '" + ns.getKelamin() + "', " +
                       "jabatan = '" + ns.getJabatan() + "' " +
                       "WHERE id = " + ns.getId();
            //menjalankan query
            this.stat.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //DELETE
    public boolean hapusKaryawan(int a){
        Karyawan ns = new Karyawan();
        ns.setId(a);
        
        try {
            this.sql = "DELETE FROM tblistkaryawan WHERE id="+ns.getId()+"";
            this.stat.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean hapusAbsen(int a){
        Karyawan k = new Karyawan();
        k.setId(a);
        
        try {
            this.sql = "DELETE FROM tbabsen WHERE no="+k.getId();
            this.stat.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
