package latihan.jdbc.controller;

import java.sql.ResultSet;
import java.sql.Statement;
import latihan.jdbc.model.Admin;

public class LoginController {
    Statement stm;
    ResultSet res;
    String sql;
    
    public LoginController(){
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }
    //buat cek loginnya (tb akun login dengan data didalem beda,
    //nama tb ku ada tbadmin isi kolom id(primary), nama, password, status buat admin bisa login
    // tbkaryawan isi kolom id, nama, password, status, telepon, kelamin, jabaran. kegunaan hanya untuk akun login user
    // tblistkaryawan isi kolom id, nama, hp, kelamin, jabatan. kegunaan untuk list data dari karyawan jadi beda sama akun login
    // tb absen isi kolom No(primary), nama, tanggal, keterangan. kegunaan untuk bagian absen
    public boolean cekLogin(String un, String pw, String st){   
        Admin adm = new Admin();
        adm.setNama(un);
        adm.setPassword(pw);
        adm.setStats(st);
        boolean status = false;
        
        try {
            sql = "SELECT * FROM tbadmin WHERE nama='" + adm.getNama() + "' AND password='" + adm.getPassword() + "' AND status='" + adm.getStats() + "';";
            
            this.res = stm.executeQuery(sql);
            
            if(res.next()) status = true;
            else status = false;
        }
        catch (Exception e) {
            System.out.println("Query gagal");
        }
        return status;
    }
    
    //cek login versi karyawannya
    public boolean cekLoginKaryawan(String un, String pw, String st){
        Admin adm = new Admin();
        adm.setNama(un);
        adm.setPassword(pw);
        adm.setStats(st);
        boolean status = false;
        
        try {
            sql = "SELECT * FROM tbkaryawan WHERE nama='" + adm.getNama() + "' AND password='" + adm.getPassword() + "' AND status='" + adm.getStats() + "';";
            
            this.res = stm.executeQuery(sql);
            
            if(res.next()) status = true;
            else status = false;
        }
        catch (Exception e) {
            System.out.println("Query gagal");
        }
        return status;
    }
    
    //user bisa bkn akun dan nnt msk ke table karyawan yg nnt bisa buat login versi karyawan
    public boolean signupKaryawan(String nm, String pw, String hp, String kl, String jb, String st) {
        Admin adm = new Admin();
        adm.setNama(nm);
        adm.setPassword(pw);
        adm.setHp(hp);
        adm.setKelamin(kl);
        adm.setJabaran(jb);
        adm.setStats(st);

        boolean status = false;

        try {
            sql = "INSERT INTO tbkaryawan (nama, password, status, telepon, kelamin, jabatan) VALUES ('"
                    + adm.getNama() + "', '"
                    + adm.getPassword() + "', '"
                    + adm.getStats() + "', '"
                    + adm.getHp() + "', '"
                    + adm.getKelamin() + "', '"
                    + adm.getJabaran() + "')";

            stm.executeUpdate(sql);
            status = true;
        } catch (Exception e) {
            System.out.println("Query gagal: " + e.getMessage());
            e.printStackTrace();
            status = false;
        }

            return status;
    }

}
