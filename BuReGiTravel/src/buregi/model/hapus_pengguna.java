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
public class hapus_pengguna {
    public Connection koneksi;
    public boolean hapuspelanggan;
    
    public boolean hapus(String idktp){
        koneksi = new koneksiDataBase().condb();
        try{
            String sql ="delete from pelanggan where id_ktp='"+idktp+"'";
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(sql);
            return hapuspelanggan = true;
        }catch(SQLException | HandlerException ex){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+ ex);
            return hapuspelanggan = false;
        }
    }
}
