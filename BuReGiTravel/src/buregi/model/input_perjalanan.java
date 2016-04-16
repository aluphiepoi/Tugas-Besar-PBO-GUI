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
public class input_perjalanan {
    public Connection koneksi;
    public boolean inputjalan;
    
    public boolean input_jalan(String trans,String pguna,String nam,String pkg,String tgl,String knd,String ptg,int tot){
        try{
            koneksi = new koneksiDataBase().condb();
            String input = "insert into tr_pejalanan values('"+trans+"','"+pguna+"','"+nam+"','"+pkg+"','"+tgl+"','"+knd+"','"+ptg+"',"+tot+")";
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(input);
            return inputjalan = true;
        }catch (SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Terjadi Error"+e);
            return inputjalan = false;
        }
    }
    
}
