/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.consoleapps;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Budi Pradnyana
 */
public class Perjalanan {
    int nomorperjalanan;
    PaketWisata paket;
    private String tanggal;
    Map<String,Pelanggan> pelanggan = new HashMap<String,Pelanggan>();

    public int getNomorperjalanan() {
        return nomorperjalanan;
    }

    public void setNomorperjalanan(int nomorperjalanan) {
        this.nomorperjalanan = nomorperjalanan;
    }

    public int jumlahPelanggan(){
        return this.pelanggan.size();
    }
    
    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    public PaketWisata getPaket() {
        return paket;
    }

    public void setPaket(PaketWisata paket) {
        this.paket = paket;
    }
    
    public void addPelanggan(Pelanggan p){
        pelanggan.put(p.getIdPelanggan(), p);
    }
    
    public Map<String,Pelanggan> getPelanggan(){
        return pelanggan;
    }
    
    public ArrayList<Pelanggan> getListPelanggan(){
        ArrayList<Pelanggan> arr = new ArrayList<Pelanggan>(pelanggan.values());
        return arr;
    }
    
    public  Pelanggan getPelangganByIndex(int i){
        List<Pelanggan> index = new ArrayList<Pelanggan>(pelanggan.values());
        return index.get(i);
    }
    
    public Pelanggan getPelangganById(int idpel){
        return pelanggan.get(idpel);
    }
    
        @Override
    public String toString(){
        String x = "Nomor Perjalanan    : " + this.nomorperjalanan +
                   "\nTanggal           : " + this.tanggal +
                   "\nPaket Wisata      : " + this.paket.getNamaPaket() + 
                   "\nHarga             : " + this.paket.getHarga()+
                   "\nPelanggan         : " + this.getListPelanggan() +"\n" ;
        return x;
    }
    
}
