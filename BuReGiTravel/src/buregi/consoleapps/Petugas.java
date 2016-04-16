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
import java.util.ArrayList;

public class Petugas extends Orang{
	private String jabatan;
        private String username;
        private String password;


        public Petugas(String username, String password, String jabatan) {
            this.username = username;
            this.password = password;
            this.jabatan = jabatan;
        }
        


	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}
	
	public String getJabatan(){
		return jabatan;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
        
}