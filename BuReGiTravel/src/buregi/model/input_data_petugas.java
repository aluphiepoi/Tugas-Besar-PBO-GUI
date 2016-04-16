/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Resa Yudha
 */
public class input_data_petugas {
    public Connection koneksi;
    public boolean inputpetugas;
    
    public boolean input_data(String id, String nama, String alamt, String tlp){
        koneksi = new koneksiDataBase().condb();
        try{
            String input = "Insert into karyawan (id_ktp,password,jabatan,nick,alamat,tlp) values('"+id+"','sopir','sopir','"+nama+"','"+alamt+"','"+tlp+"')";
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(input);
            return inputpetugas = true;
        }catch(SQLException | HeadlessException ex){
            JOptionPane.showMessageDialog(null,"Terjadi Error"+ex);
            return inputpetugas = false;
        }
    }
    
}
