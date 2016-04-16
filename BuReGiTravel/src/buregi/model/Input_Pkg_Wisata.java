/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.model;

import com.sun.xml.internal.ws.handler.HandlerException;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Resa Yudha
 */
public class Input_Pkg_Wisata {
    public Connection koneksi;
    boolean inputPW;
    boolean inputwisatas;
    public int num;
    public int harga;
    
    public boolean input_PW(String id,String nama){
        koneksi = new koneksiDataBase().condb();
        try{
            String sql ="insert into paket values('"+id+"','"+nama+"',"+harga+")";
            System.out.println(sql);
            Statement stat = (Statement) koneksi.createStatement();
            stat.executeUpdate(sql);
            return inputPW = true;
        }catch(SQLException | HandlerException ex){
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+ ex);
            return inputPW = false;
        }
    }
    
    public boolean input_Wisatas(String id,ArrayList<String> list){
        koneksi = new koneksiDataBase().condb();
        int k=0;
        for(int i=0;i < list.size();i++){
            try{
                String na = list.get(i);
                System.out.println(na);
                String sql1="select * from tb_wisata where nama='"+na+"'";
                System.out.println("Sudah Terlewati 1");
                System.out.println(sql1);
                Statement mux = koneksi.createStatement();
                System.out.println("Sudah Terlewati 2");
                ResultSet res = mux.executeQuery(sql1);
                while(res.next()){
                    num = Integer.parseInt(res.getString("id_wisata"));
                    harga = harga + Integer.parseInt(res.getString("biaya"));
                }
                System.out.println("Sudah Terlewati 3");
                System.out.println(num);
                k++;
                System.out.println(harga);
                //System.out.println(num);
            }catch(SQLException as){
                System.out.println("salah");
            }
            try{
                String sql ="insert into tampung_paket_wisata values('"+id+"',"+num+")";
                System.out.println(sql);
                Statement stat = (Statement) koneksi.createStatement();
                stat.executeUpdate(sql);
                System.out.println("Berhasil Masuk ke Tabel");
            }catch(SQLException | HandlerException ex){
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan"+ ex);
            }
        }
        if(k==(list.size())){
           inputwisatas=true;
        }
        return inputwisatas;
    }
}
