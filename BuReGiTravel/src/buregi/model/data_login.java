package buregi.model;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class data_login {
    public boolean succes;
    public int operator = 0;
    public Statement cn;
    public Connection koneksi;
    String password, kode,loginas;
    private Component rootPane;

    public String getLoginas() {
        return loginas;
    }

    public void setLoginas(String loginas) {
        this.loginas = loginas;
    }
    
    public data_login() {
        koneksiDataBase konek = new koneksiDataBase();
        koneksi = new koneksiDataBase().condb();
    }

    public boolean masuk(String user, String pass) {
        kode = user;
        password = pass;
        try {
            String sql = "select * from karyawan where password='" + pass + "' and nick='" + user + "'";
            System.out.println(pass + " " + user);
            Statement stat = koneksi.createStatement();
            ResultSet res = stat.executeQuery(sql);
            int a = 0;
            while (res.next()) {
                a = res.getRow();
            }
            if (a == 1) {
                JOptionPane.showMessageDialog(rootPane, "login as operator succesful,\nhappy working :)");
                succes = true;
            }
            if(a==0) {
                JOptionPane.showMessageDialog(rootPane, "Kode/Password salah");
                succes = false;
            }
            while (res.next()) {
            }
        } catch (SQLException | HeadlessException e) {
        }
        return succes;
    }
}
