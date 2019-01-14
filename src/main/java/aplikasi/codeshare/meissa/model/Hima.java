package main.java.aplikasi.codeshare.meissa;

import java.util.Scanner;

public class Hima {
    Integer id_anggota,nim,id_divisi,id_proker,id_ketuplak;
    String nama_anggota,gender,nama_divisi,nama_proker;

    public Hima(Integer id_anggota, Integer nim, Integer id_divisi, Integer id_proker, Integer id_ketuplak, String nama_anggota, String gender, String nama_divisi, String nama_proker) {
        this.id_anggota = id_anggota;
        this.nim = nim;
        this.id_divisi = id_divisi;
        this.id_proker = id_proker;
        this.id_ketuplak = id_ketuplak;
        this.nama_anggota = nama_anggota;
        this.gender = gender;
        this.nama_divisi = nama_divisi;
        this.nama_proker = nama_proker;
    }

    public Hima() {
    }

    public Integer getId_anggota(){
       return id_anggota;
    }
    public void setId_anggota(Integer a){
       this.id_anggota=id_anggota;
    }
    public String getNama_anggota(){
        return nama_anggota;
    }
    public void setNama_anggota(String a){
       this.nama_anggota=nama_anggota;
    }
    public Integer getNim(){
        return nim;
    }
    public void setNim(Integer a){
        this.nim=nim;
    }
    public String getGender(){
         return gender;
    }
    public void setGender(String a){
         this.gender=gender;
    }
    public Integer getId_divisi(){
        return id_divisi;
    }
    public void setId_divisi(Integer a){
        this.id_divisi=id_divisi;
    }
    public String getNama_divisi(){
        return nama_divisi;
    }
    public void setNama_divisi(String a){
        this.nama_divisi=nama_divisi;
    }
    public Integer getId_proker(){
        return id_proker;
    }
    public void setId_proker(Integer  a){
        this.id_proker=id_proker;
    }
    public String getNama_proker(){
        return nama_proker;
    }
    public void setNama_proker(String a){
        this.nama_proker=nama_proker;
    }
    public Integer getId_ketuplak(){
        return id_ketuplak;
    }
    public void setId_ketuplak(Integer a){
        this.id_ketuplak=id_ketuplak;
    }
    
    public static void main(String[] args) {
        Hima hm = new Hima()   ;
        Anggota agg= new Anggota();
        Divisi div = new Divisi();
        Proker brg = new Proker();
        
        Scanner input = new Scanner (System.in);
        System.out.println("Pilih Data Yang Ingin Diinputkan :\n1. Data Anggota\n2. Data Divisi\n3. Data Inventaris");
        System.out.print("Pilihan  =  "); 
        Integer pilihan = input.nextInt();
        if(pilihan==1){
            System.out.println("=============================");
            System.out.println("Input Data Anggota Baru");
            System.out.print("Id Anggota    = ");
            int id_anggota = input.nextInt();
            agg.setId_anggota(id_anggota);
            System.out.print("Id Divisi     = ");
            int id_divisi = input.nextInt();
            System.out.print("Nama Anggota  = ");
            String nama_anggota = input.nextLine();
            System.out.print("NIM           = ");
            int nim = input.nextInt();
            System.out.print("Gender        = ");
            String gender = input.nextLine();
            System.out.println("=============================");
            agg.output();
        }
        else if(pilihan==2){
            System.out.println("=============================");
            System.out.println("Input Data Divisi Baru");
            System.out.print("Id Divisi    = ");
            Integer id_divisi=input.nextInt();
            System.out.print("Nama Divisi  = ");
            String nama_divisi=input.nextLine();
            System.out.println("=============================");
            
            div.output();
        }
        else if(pilihan==3){
            System.out.println("=============================");
            System.out.println("Input Data Proker Baru");
            System.out.print("Id Proker    = ");
            Integer id_proker=input.nextInt();
            System.out.print("Id Ketuplak    = ");
            Integer id_ketuplak=input.nextInt();
            System.out.print("Nama Proker  = ");
            String nama_ketuplak=input.nextLine();
            System.out.println("=============================");
            
            brg.output();
        }
        else {
            System.out.println("Inputan Anda Salah");
        }
        
        
        
    }
    
}


class Anggota extends Hima{
    public Anggota(){
        setId_anggota(id_anggota);
        setId_divisi(id_divisi);
        setNama_anggota(nama_anggota);
        setNim(nim);
        setGender(gender);
    }
    public void output(){
        System.out.println("\tData Anggota");
        System.out.println("Id Anggota    = "+new Anggota().getId_anggota());
        System.out.println("Id Divisi     = "+new Anggota().getId_divisi());
        System.out.println("Nama Anggota  = "+new Anggota().getNama_anggota());
        System.out.println("NIM           = "+new Anggota().getNim());
        System.out.println("Gender        = "+new Anggota().getGender());
      
    }
}
class Divisi extends Hima{
    public Divisi(){
        setId_divisi(id_divisi);
        setNama_divisi(nama_divisi);
    }
    public void output(){
        System.out.println("\tData Anggota");
        System.out.println("Id Divisi     = "+new Divisi().getId_divisi());
        System.out.println("Nama Divisi   = "+new Divisi().getNama_divisi());
    }
}
class Proker extends Hima{
    public Proker(){
        setId_proker(id_proker);
        setId_ketuplak(id_ketuplak);
        setNama_proker(nama_proker);
    }
    public void output(){
        System.out.println("\tData Anggota");
        System.out.println("Id Barang     = "+new Proker().getId_proker());
        System.out.println("Id Ketuplak   = "+new Proker().getId_ketuplak());
        System.out.println("Nama Barang   = "+new Proker().getNama_proker());
    }
}
     