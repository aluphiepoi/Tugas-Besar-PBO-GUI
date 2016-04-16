/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.consoleapps;

/**
 *
 * @author Budi Pradnyana
 */

public class TempatWisata
{

    
    private String nama;
    private String kab;
    private String alamat; 
    private int biaya; 

    public TempatWisata(String nama, String kab, String alamat, int biaya) {
        this.nama = nama;
        this.kab = kab;
        this.alamat = alamat;
        this.biaya = biaya;
    }
    
    @Override
    public String toString(){
        String x = "\nNama Tempat   : " + this.nama +
                   "\nKabupaten   : " + this.kab +
                   "\nAlamat      : " + this.alamat+
                   "\nBiaya Masuk : "+this.biaya+"\n";
        return x;
    }
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public String getNama()
    {
        return this.nama;
    }
    
    public void setKab(String kab)
    {
        this.kab = kab;
    }
    
    public String getKab()
    {
        return this.kab;
    }
    
    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }
    
    public String getAlamat()
    {
        return this.alamat;
    }
    
    public void setBiaya(int biaya)
    {
        this.biaya = biaya;
    }
    
    public int getBiaya()
    {
        return this.biaya;
    }
    
//    @Override
//    public String toString(){
//        return "    Nama Tempat : "+this.nama+
//                "\n Kabupaten   : "+this.kab+
//                "\n Alamat      : "+this.alamat+
//                "\n Tiket masuk : "+this.biaya+"\n"+"\n";
//    }
}
