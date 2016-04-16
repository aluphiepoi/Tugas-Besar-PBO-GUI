/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.model;

import buregi.form.Menu;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Resa Yudha
 */
public class input_kendaraan {
    public Connection koneksi;
    public boolean inputkendaraan;
    
    public boolean input_kend(String nama,String idk,int jumduk){
        try{
            koneksi = new koneksiDataBase().condb();
            String input = "insert into kendaraan (id_polisi,Nama,kursi) values('"+idk+"','"+nama+"','"+jumduk+"')";
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(input);
            return inputkendaraan= true;
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+e);
            return inputkendaraan = false;
        }
    } 
}
