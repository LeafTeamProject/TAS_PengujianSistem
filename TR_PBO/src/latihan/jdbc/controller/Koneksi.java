package latihan.jdbc.controller;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Koneksi {
    public static Connection con;
    public static Statement stm;
    
    public void config(){
        try{
            //deklarasi String Connection : url, User, Pass database
            String url = "jdbc:mysql://localhost/dbabsen";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Connection merangkai string connection
            con = DriverManager.getConnection(url, user, pass);
            
            //Statement --> membuat SQL Statement
            stm = (Statement) con.createStatement();
            System.out.println("Koneksi Berhasil....");
        }
        catch(Exception e){
            System.out.println("Koneksi Gagal Sad");
        }
    }
}
