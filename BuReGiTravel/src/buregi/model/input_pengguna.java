/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.model;

import com.sun.xml.internal.ws.handler.HandlerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Resa Yudha
 */
public class input_pengguna {
    public Connection koneksi;
    public boolean inputpengguna;
    
    public boolean input_peng(String nama,String idk,String alamt,String tlp){
        koneksi = new koneksiDataBase().condb();
        try {
            String input = "insert into pelanggan (nama,id_ktp,alamat,tlp) values('"+nama+"','"+idk+"','"+alamt+"','"+tlp+"')";
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(input);
            return inputpengguna= true;  
        }catch(SQLException | HandlerException ex){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+ex);
            return inputpengguna = false;
        }
    }
}
