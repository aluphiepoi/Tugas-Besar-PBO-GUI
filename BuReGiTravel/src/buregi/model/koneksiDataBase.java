package buregi.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class koneksiDataBase {
    public Connection koneksi;
    public ResultSet hasil;
    private java.sql.Statement stat;
    private String query, url, database;
    public java.sql.Statement cn;

    public koneksiDataBase() {
        condb();
    }
    Connection con;

    public void panggildriver() {
        try {
            String driver = "jdbc:mysql://localhost:3306";
            Class.forName(driver);
            System.out.println("dirver jalan");
        } catch (Exception e) {
            System.out.println("driver error");
        }
    }

    public Connection condb() {
        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo", "root","");
            System.out.println("koneksi sukses");
        } catch (Exception e) {
            System.out.println("koneksi gagal");
        }
        return koneksi;
    }
    
}
