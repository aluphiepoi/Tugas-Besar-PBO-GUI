
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buregi.consoleapps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Budi Pradnyana
 * Asumsinya :
 *  hrus register dlu
 *  Input tempat wisata dulu
 *  Input paket wisata 
 *  Barulah input perjalanan yaa
 */
public class Aplikasi {
    
    ArrayList<Petugas> dbPetugas = new ArrayList<Petugas>();
    ArrayList<PaketWisata> dbPaket = new ArrayList<PaketWisata>();
    ArrayList<Pelanggan> dbPelanggan = new ArrayList<Pelanggan>();
    ArrayList<Perjalanan> dbPerjalanan = new ArrayList<Perjalanan>();
    ArrayList<TempatWisata> dbTempat = new ArrayList<TempatWisata>();
    Scanner logS;
    
    public void mainMenu(){
        
        Scanner sc = new Scanner(System.in);
        this.logS = sc;
        int log=0;
        do{
            menuAwal(); 
        }while(log!=0);
            
    }
    
    
    public void registerPetugas(){
        Scanner scan = new Scanner(System.in);
        System.out.print(" Nama : ");
        String nama = scan.nextLine();
        System.out.print(" Alamat : ");
        String alamat = scan.nextLine();
        System.out.print(" Jabatan : ");
        String jabatan = scan.nextLine();
        System.out.print(" Username : ");
        String username = scan.next();
        System.out.print(" Password : ");
        String password = scan.next();
        
        Petugas ptgsbaru = new Petugas(username,password,jabatan);
        ptgsbaru.setNama(nama);
        ptgsbaru.setAlamat(alamat);
        dbPetugas.add(ptgsbaru);
        System.out.println("  Data Petugas sudah ditambahkan!");
        this.loginPetugas();
    }
    
    public boolean cekLogin(String username, String password){
        for(int i=0; i<dbPetugas.size();i++){
            if(Arrays.equals(dbPetugas.get(i).getUsername().toCharArray(), username.toCharArray())){
                if(Arrays.equals(dbPetugas.get(i).getPassword().toCharArray(), password.toCharArray())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void loginPetugas(){
        Scanner scan = new Scanner(System.in);
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("          LOGIN         ");
        System.out.print("Usernmae : ");
        String username = scan.next();
        System.out.print("Password : ");
        String password = scan.next();
        if(this.cekLogin(username,password)){
            this.menuUtama();
        } else {
            System.out.println("Login salah!");
            this.menuAwal();
        }
    }
    
    
    public void menuAwal(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        System.out.println(" Selamat Datang! ");
        System.out.println(" 1. Register");
        System.out.println(" 2. Login");
        System.out.println(" 0. Exit");
        System.out.print("Input Menu : ");
        int log = logS.nextInt();
        switch(log){
            case 1:
            this.registerPetugas();
            case 2:
            this.loginPetugas();
            case 0:
            System.exit(0);
            default:
            System.out.println("Input tidak tersedia!");
        }
    }  
    
    public void menuUtama(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println(" 1. Perjalanan");
        System.out.println(" 2. Tempat Wisata");
        System.out.println(" 3. Paket Wisata");
        System.out.println(" 0. Exit");
        System.out.print("Input Menu : ");
        int log = logS.nextInt();
        switch(log){
            case 1:
                this. menuPerjalanan();
            break;
            case 2:
                this.menuTempatWisata();
            break;
            case 3:
                this.menuPaketWisata();
            break;
            case 0:
            System.exit(0);
            default:
            System.out.println("Input tidak tersedia!");
        }
    }
    
    
    public void inputTempatWisata(){
        Scanner scan = new Scanner(System.in);
        //this.logS = scan;
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("  -Input Tempat Wisata-  ");
        System.out.print("Nama tempat : ");
        String nama = scan.nextLine();
        System.out.print("Kabupaten : ");
        String kab = scan.nextLine();
        System.out.print("Alamat : ");
        String alamat = scan.nextLine();
        System.out.print("Biaya masuk : ");
        int biaya = scan.nextInt();
        TempatWisata tempatbaru = new TempatWisata(nama,kab,alamat,biaya);    
        this.dbTempat.add(tempatbaru);
        System.out.println("Berhasil Menambah Tempat Wisata!");
        scan.nextLine();
        this.menuTempatWisata();
    }
    
    public void viewTempat(){
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("  -View Tempat Wisata-  ");
        if(this.dbTempat.isEmpty()){
            System.out.println("   Tidak ada data!  ");
            System.out.println();
        } else {
//           for(int i=0; i<this.dbTempat.size();i++){
//            System.out.println("Nama Tempat : "+this.dbTempat.get(i).getNama());
//            System.out.println("Kabupaten : "+this.dbTempat.get(i).getKab());
//            System.out.println("Alamat : "+this.dbTempat.get(i).getAlamat());
//            System.out.println("Tiket Masuk : "+this.dbTempat.get(i).getBiaya());
//            System.out.println();
//            } 
            System.out.println(this.dbTempat);
        }
         this.menuTempatWisata();
    }
    
//    public int cekTempat(String namatempat){
//        for(int i=0; i<dbTempat.size();i++){
//            if(Arrays.equals(dbTempat.get(i).getNama().toCharArray(), namatempat.toCharArray())){
//                    return i;
//            }
//        }
//        return -1;
//    }
    
    public void removeTempat(){
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("  -Delete Tempat Wisata-  ");
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        for(int i=0; i<this.dbTempat.size();i++){
            System.out.println((i+1)+". Nama Tempat : "+this.dbTempat.get(i).getNama());
        }
        System.out.print("Hapus nomor : ");
        int nmtempat = scan.nextInt();
        if(nmtempat <= this.dbTempat.size()){
            this.dbTempat.remove(nmtempat-1);
            System.out.println("Sudah didelete!");
        } else {
            System.out.println("Tidak Ada!");
        }
//        int resultCheck = cekTempat(nmtempat);
//        if(resultCheck != -1) {
//            dbTempat.remove(resultCheck);
//            System.out.println("Sudah didelete!");
//        } else {
//            System.out.println("Tidak Ada!");
//        }
         this.menuTempatWisata(); 
    }
    
    public void menuTempatWisata(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("     -Tempat Wisata-    ");
        System.out.println(" 1. Input Tempat Wisata");
        System.out.println(" 2. View Tempat Wisata");
        System.out.println(" 3. Delete Tempat Wisata");
        System.out.println(" 0. Back");
        System.out.print("   Input Menu : ");
        int log = logS.nextInt();
        switch(log){
            case 1:
                this.inputTempatWisata();
                break;
            case 2:
                this.viewTempat();
                scan.nextLine();
                break;
            case 3:
                this.removeTempat();
                scan.nextLine();
                break;
            case 0:
                this.menuUtama();
            default:
            System.out.println("Input tidak tersedia!");
        }
   
    }
    
    
    public void menuPaketWisata(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("     -Paket Wisata-    ");
        System.out.println(" 1. Input Paket Wisata");
        System.out.println(" 2. View Paket Wisata");
        System.out.println(" 3. Delete Paket Wisata");
        System.out.println(" 0. Back");
        System.out.print("   Input Menu : ");
        int log = logS.nextInt();
        switch(log){
            case 1:
                this.inputPaketWisata();
                break;
            case 2:
                this.viewPaket();
                scan.nextLine();
                break;
            case 3:
                this.removePaket();
                scan.nextLine();
                break;
            case 0:
                this.menuUtama();
            default:
            System.out.println("Input tidak tersedia!");
        }
    }
    
    public void inputPaketWisata(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        String loop;
        PaketWisata pktbaru = new PaketWisata();
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("     -Paket Wisata-    ");
        System.out.print("Nama Paket : ");
        String nmpkt = scan.nextLine();
        pktbaru.setNamaPaket(nmpkt);
        System.out.println("Daftar Tempat Wisata : ");
        for(int i=0; i<this.dbTempat.size();i++){
            System.out.println("     "+(i+1)+". Nama Tempat : "+this.dbTempat.get(i).getNama());
        }
        System.out.print("Pilih Tempat Wisata : ");
        int tmptwisata = scan.nextInt();
        pktbaru.addTempatWisata(this.dbTempat.get(tmptwisata-1));
        System.out.println("Tempat Wisata ditambahkan!");
        do{
            System.out.print("Tambah Tempat Wisata [Y/N] : ");
            loop=scan.next();
            if(loop.equals("Y")||loop.equals("y")){
                System.out.print("Pilih Tempat Wisata : ");
                tmptwisata = scan.nextInt();
                if(pktbaru.daftarTujuanWisata.contains(this.dbTempat.get(tmptwisata-1))){
                    System.out.println("Tempat Wisata sudah ada!");
                } else {
                    pktbaru.addTempatWisata(this.dbTempat.get(tmptwisata-1));
                    System.out.println("Tempat Wisata ditambahkan!");
                }
                
            }
        }while(loop.equals("Y") || loop.equals("y"));
        System.out.print("Harga Paket : ");
        Double hrg = scan.nextDouble();
        pktbaru.setHarga(hrg);
        
        this.dbPaket.add(pktbaru);
        System.out.println();
        this.menuPaketWisata();
    }
    
    public void viewPaket(){
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("  -View Paket Wisata-  ");
        if(this.dbPaket.isEmpty()){
            System.out.println("   Tidak ada data!  ");
            System.out.println();
        } else {
//           for(int i=0; i<this.dbPaket.size();i++){
//            System.out.println("Nama Paket : "+this.dbPaket.get(i).getNamaPaket());
//            System.out.println("Daftar Tempat Wisata : ");
//            for(int j=0; j<this.dbPaket.get(i).daftarTujuanWisata.size();j++){
//                System.out.println("      "+(j+1)+". "+this.dbPaket.get(i).daftarTujuanWisata.get(j).getNama());
//            }
//            System.out.println("Harga : "+this.dbPaket.get(i).getHarga());
//            System.out.println();
//            } 
              System.out.println(this.dbPaket);
        }
        this.menuPaketWisata();
    }
    
    
    public void removePaket(){
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("  -Delete Paket Wisata-  ");
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        for(int i=0; i<this.dbPaket.size();i++){
            System.out.println((i+1)+". Nama Paket : "+this.dbPaket.get(i).getNamaPaket());
        }
        System.out.print("Hapus nomor : ");
        int nmtempat = scan.nextInt();
        if(nmtempat <= this.dbPaket.size()){
            this.dbPaket.remove(nmtempat-1);
            System.out.println("Sudah didelete!");
        } else {
            System.out.println("Tidak Ada!");
        }
        this.menuPaketWisata();
    }
    
    public void menuInputPerjalanan(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        String loop;
        Perjalanan prjbaru = new Perjalanan();
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("   -Input Perjalanan-   ");
        System.out.print("Tanggal Perjalanan [dd/mm/yyyy] : ");
        String tglper = scan.nextLine();
        prjbaru.setTanggal(tglper);
        System.out.println("Paket Wisata : ");
        for(int i=0; i<this.dbPaket.size();i++){
            System.out.println("    "+(i+1)+". Paket : "+this.dbPaket.get(i).getNamaPaket());
        }
        System.out.print("Pilih Paket : ");
        int pilpkt = scan.nextInt();
        prjbaru.setPaket(this.dbPaket.get(pilpkt-1));
        System.out.println(" Harga  :  "+this.dbPaket.get(pilpkt-1).getHarga());
        System.out.println("Data pelanggan ");
        System.out.print("   Nama   : ");
        String namapel = scan.nextLine();
        namapel = scan.nextLine();
        System.out.print("   ID KTP : ");
        String idpel = scan.next();
        
        System.out.print("   Alamat : ");
        String alpel = scan.nextLine();
        alpel = scan.nextLine();
        Pelanggan plgbaru = new Pelanggan(idpel, namapel, alpel);
        prjbaru.addPelanggan(plgbaru);
        System.out.println("Pelanggan ditambahkan!");
        do{
            System.out.print("Tambah Pelanggan [Y/N] : ");
            loop=scan.next();
            if(loop.equals("Y")||loop.equals("y")){
                System.out.println("Data pelanggan ");
                System.out.print("   Nama   : ");
                namapel = scan.nextLine();
                namapel = scan.nextLine();
                System.out.print("   ID KTP : ");
                idpel = scan.next();
                
                System.out.print("   Alamat : ");
                alpel = scan.nextLine();
                alpel = scan.nextLine();
                Pelanggan plgbaru2 = new Pelanggan(idpel, namapel, alpel);
                if(prjbaru.getPelanggan().containsKey(idpel)){
                    System.out.println("    Pelanggan sudah terdaftar di perjalanan!");
                } else {
                    prjbaru.addPelanggan(plgbaru2);
                    System.out.println("    Pelanggan ditambahkan!");
                }
                
            }
        }while(loop.equals("Y") || loop.equals("y"));
        prjbaru.setNomorperjalanan(this.dbPerjalanan.size()+1);
        this.dbPerjalanan.add(prjbaru);
        this.menuPerjalanan();
    }
    
    public void viewPerjalanan(){
        if(this.dbPaket.isEmpty()){
            System.out.println("   Tidak ada data!  ");
            System.out.println();
        } else {
//        for(int i=0; i<this.dbPerjalanan.size();i++){
//            System.out.println("Nomor Perjalanan   : "+this.dbPerjalanan.get(i).getNomorperjalanan());
//            System.out.println("Tanggal Perjalanan : "+this.dbPerjalanan.get(i).getTanggal());
//            System.out.println("Paket Wisata       : "+this.dbPerjalanan.get(i).getPaket().getNamaPaket());
//            System.out.println("Harga              : "+this.dbPerjalanan.get(i).getPaket().getHarga());
//            System.out.println("Daftar Pelanggan   :");
//            for(int j=0; j<this.dbPerjalanan.get(i).jumlahPelanggan();j++){
//                System.out.println("     "+this.dbPerjalanan.get(i).getPelangganByIndex(j).getIdPelanggan()+" : "+this.dbPerjalanan.get(i).getPelangganByIndex(j).getNama());
//            }           
//        }
            System.out.println(this.dbPerjalanan);
        }
        this.menuPerjalanan();
    }
    
    public void removePerjalanan(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        for(int i=0; i<this.dbPaket.size();i++){
            System.out.println((i+1)+". Nomor Perjalanan : "+this.dbPerjalanan.get(i).getNomorperjalanan()+", Tanggal Perjalanan : "+this.dbPerjalanan.get(i).getTanggal());     
        }
        System.out.print("Hapus nomor : ");
        int pil = scan.nextInt();
        if(pil <= this.dbPerjalanan.size()){
            this.dbPerjalanan.remove(pil-1);
            System.out.println("Sudah didelete!");
        } else {
            System.out.println("Tidak Ada!");
        }
        this.menuPerjalanan();
    }
    
    public void menuPerjalanan(){
        Scanner scan = new Scanner(System.in);
        this.logS = scan;
        System.out.println(" Biro Perjalanan -JAEN- ");
        System.out.println("       -Perjalanan-     ");
        System.out.println(" 1. Input Perjalanan");
        System.out.println(" 2. View Perjalanan");
        System.out.println(" 3. Delete Perjalanan");
        System.out.println(" 0. Back");
        System.out.print(" Input Menu : ");
        int log = logS.nextInt();
        switch(log){
            case 1:
            this.menuInputPerjalanan();
            break;
            case 2:
            this.viewPerjalanan();
            break;
            case 3:
            this.removePerjalanan();
            break;
            case 0:
            this.menuUtama();
            default:
            System.out.println("Input tidak tersedia!");
        }
    }
}
