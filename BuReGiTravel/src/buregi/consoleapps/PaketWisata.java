/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.consoleapps;

import java.util.ArrayList;

public class PaketWisata
{
    //private TempatWisata[] daftarTujuanWisata;
    ArrayList<TempatWisata> daftarTujuanWisata = new ArrayList<TempatWisata>();
    private double harga;
    private String namaPaket;
    private int jumwis=0;
    
//    public PaketWisata(double harga,String namaPaket,int max)
//    {
//        this.harga = harga;
//        this.namaPaket = namaPaket;
//        daftarTujuanWisata = new TempatWisata[max];
//    }
    
    public void setHarga(double harga)
    {
        this.harga = harga;
    }
    
    public double getHarga()
    {
        return this.harga;
    }
    
    public void setNamaPaket(String namaPaket)
    {
        this.namaPaket = namaPaket;
    }
    
    public String getNamaPaket(){
        return this.namaPaket;
    }
    
    public void addTempatWisata(TempatWisata wis)
    {
//        if(jumwis<=daftarTujuanWisata.length){
//            daftarTujuanWisata[jumwis] = wis;
//            jumwis++;
//        }
        this.daftarTujuanWisata.add(wis);
    }
    
    @Override
    public String toString(){
        String x = "Nama Paket   : " + this.namaPaket +
                   "\nTempat Wisata   : " +
                   "\n     "+this.daftarTujuanWisata+
                   "\nHarga      : " + this.harga;
        return x;
    }
    
}
