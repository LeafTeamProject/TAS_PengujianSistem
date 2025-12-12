/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.jdbc.controller;

import java.sql.ResultSet;
import java.sql.Statement;
//import latihan.jdbc.model.Admin;
import latihan.jdbc.model.User;

public class UserLoginController {
    Statement stm;
    ResultSet res;
    String sql;
    
    public UserLoginController(){
        Koneksi db = new Koneksi();
        db.config();
        stm = db.stm;
    }
    
    //query SELECT
    public boolean cekLogin(String un, String pw){
        User adm = new User();
        adm.setNama(un);
        adm.setPassword(pw);
        boolean status = false;
        
        try {
            //menuliskan perimtah sqlnya
            sql = "SELECT * FROM tbuser WHERE nama='"+adm.getNama()+"' AND password='"+adm.getPassword()+"';";
            
            //mengeksekusi / menjalankan sql nya
            //execitequery hanya berlaku untuk perintah SELECT
            this.res = stm.executeQuery(sql);
            
            //jika res memperoleh hasil
            if(res.next()) status = true;
            else status = false;
        }
        catch (Exception e) {
            System.out.println("Query gagal");
        }
        return status;
    }
}
