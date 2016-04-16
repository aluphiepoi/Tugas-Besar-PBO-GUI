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
public class Pelanggan extends Orang {
    private String idPelanggan;

    public Pelanggan(String idPelanggan, String nama, String alamat) {
        this.idPelanggan = idPelanggan;
        this.setNama(nama);
        this.setAlamat(alamat);
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public void setNama(String nama) {
        super.setNama(nama);
    }
    
    @Override
    public String getAlamat() {
        return super.getAlamat();
    }

    @Override
    public void setAlamat(String alamat) {
        super.setAlamat(alamat);
    }
    
    @Override
    public String toString(){
        String x = "     ID     : " + this.idPelanggan +
                 "\n     Nama   : " + this.getNama() +
                 "\n     Alamat     "+this.getAlamat();
        return x;
    }
}
