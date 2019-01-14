package com.unikom.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //    JDBC driver name and database URL
    static final String JDBC_DRIVER =
            "com.mysql.cj.jdbc.Driver";
    static final String DB_URL =
            "jdbc:mysql://localhost/kelompok_satu";

    //    Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
//        System.out.println
//("ini jdbc driver :"+JDBC_DRIVER);
//        System.out.println
//("ini db url :"+DB_URL);
//        System.out.println
//("ini user :"+USER);
//        System.out.println
//("ini pass :"+PASS);
//    }
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sqlorganisasi, sqlmobil, sqlbarang, sqlkucing, sqlorgan_dalam, sqlpohon;

            //AMBIL DATA ORGANISASI
            sqlorganisasi = "select * from organisasi";
           ResultSet rsorganisasi = stmt.executeQuery(sqlorganisasi);
            narasi narasii = new narasi();
            List<narasi> narasiList = new ArrayList<>();

            if (rsorganisasi.next()) {

                Organisasi organisasi = new Organisasi();

                organisasi.setNama_anggota(rsorganisasi.getString("nama_anggota"));
                //System.out.print("Seorang anggota organisasi bernama " + organisasi.getNama_anggota());

                narasii.setId_organisasi(organisasi);
            }
            // AMBIL DATA MOBIL
            sqlmobil = "select * from mobil";
            ResultSet rsmobil = stmt.executeQuery(sqlmobil);
            if (rsmobil.next()) {
                Mobil mobil = new Mobil();
                mobil.setJenis(rsmobil.getString("jenis"));
                //System.out.print(" Sedang mengendarai " + mobil.getJenis());
                narasii.setId_mobil(mobil);
            }
            // AMBIL DATA BARANG
            sqlbarang = "select * from barang";
            ResultSet rsbarang = stmt.executeQuery(sqlbarang);
            if (rsbarang.next()) {
                Barang barang = new Barang();
                barang.setNama(rsbarang.getString("nama_barang"));
                //System.out.print(" Mengangkut " + barang.getNama());
                narasii.setId_barang(barang);
            }
            // AMBIL DATA KUCING
            sqlkucing = "select * from kucing";
            ResultSet rskucing = stmt.executeQuery(sqlkucing);
            if (rskucing.next()) {
                Kucing kucing = new Kucing();
                kucing.setNama(rskucing.getString("nama_kucing"));
                //System.out.print(" Menabrak kucing " + kucing.getNama());
                narasii.setId_kucing(kucing);
            }
            // AMBIL DATA ORGAN DALAM
            sqlorgan_dalam = "select * from organ_dalam";
            ResultSet rsorgandalam = stmt.executeQuery(sqlorgan_dalam);
            if (rsorgandalam.next()) {
                Organdalam organdalam = new Organdalam();
                organdalam.setJenis_organ(rsorgandalam.getString("jenis_organ"));
                //System.out.print(" Menyebabkan organ dalam " + organdalam.getJenis_organ() + " Terlihat ");
                narasii.setId_organ(organdalam);
            }
            // AMBIL DATA POHON
            sqlpohon = "select * from pohon";
            ResultSet rspohon = stmt.executeQuery(sqlpohon);
            if (rspohon.next()) {
                Pohon pohon = new Pohon();
                pohon.setnama(rspohon.getString("nama_pohon"));
                //System.out.print(" Dikuburkan Dibawah Pohon " + pohon.getnama());
                narasii.setId_pohon(pohon);
                narasiList.add(narasii);
            }
                //Display values

                for (narasi narasi2 : narasiList){

                    System.out.println("|========================================================|");
                    System.out.println("Seorang anggota organisasi yang bernama \n"+narasi2.getId_organisasi().getNama_anggota()+
                            " sedang mengendarai " + narasi2.getId_mobil().getJenis()+
                            " yang mengangkut "+ narasi2.getId_barang().getNama()+
                            ", selang 30 menit dalam perjalanan, \n tidak sengaja menabrak kucing "+ narasi2.getId_kucing().getNama()+
                            " yang menyebabkan organ dalam "+  narasi2.getId_organ().getJenis_organ()+ " sampai terlihat" +
                            " akhirnya kucing "+narasi2.getId_kucing().getNama()+ "\n dikuburkan Dibawah Pohon "+ narasi2.getId_pohon().getnama());
                }
              //  System.out.print("Nama: " + organisasi.getNama_anggota());


            System.out.println("");
            System.out.println("");
            System.out.println(" Penanda no eror");
        } catch (Exception e) {
            System.out.println("Masuk Jurang");
            e.printStackTrace();
        }
    }




//organisasi membawa mobil yang membawa barang,kemudian mobil menambrak kucing sampai organ_dalamnya keluar dan dikubur di bawah pohon

    // INI OBJECT ORGANISASI
    public static class Organisasi {
        private Integer id_anggota;
        private String nama_anggota,gender;

        public Organisasi (String nama_anggota, String gender,  Integer id_anggota){
            this.nama_anggota=nama_anggota;
            this.gender=gender;
            this.id_anggota=id_anggota;
        }
        public Organisasi(){
        }
        public Integer getId_anggota(){
            return id_anggota;
        }
        public void setId_anggota(Integer id_anggota){
            this.id_anggota=id_anggota;
        }
        public String getNama_anggota(){
            return nama_anggota;
        }
        public void setNama_anggota(String nama_anggota){
            this.nama_anggota=nama_anggota;
        }
        public String getGender(){
            return gender;
        }
        public void setGender(String gender){
            this.gender=gender;
        }
    }

    // INI OBJECT MOBIL
    public static class Mobil {
        //  INI VARIABEL-VARIABEL MOBIL
        private String nama;
        private String jenis;
        private Integer jumlahban;

        public Mobil(String nama, String jenis, Integer jumlahban) {
            this.nama = nama;
            this.jenis = jenis;
            this.jumlahban = jumlahban;
        }
        public Mobil() {

        }
        //  INI METHOD GETTER SETTER OBJECT MOBIL
        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getJenis() {
            return jenis;
        }

        public void setJenis(String jenis) {
            this.jenis = jenis;
        }

        public Integer getJumlahban() {
            return jumlahban;
        }

        public void setJumlahban(Integer jumlahban) {
            this.jumlahban = jumlahban;
        }
    }

    //  INI OBJECT BARANG
    public static class Barang {
        //INI VARIABLE BARANG
        private String nama_barang;
        private Integer qty;
        private Integer harga;

        //INI CONSTRUCTOR ALL BARANG
        public Barang(String nama_barang, Integer qty, Integer harga) {
            this.nama_barang = nama_barang;
            this.qty = qty;
            this.harga = harga;
        }
        //
        public Barang() {
        }
        public String getNama() {
            return nama_barang;
        }
        public void setNama(String newNama_Barang) {
            this.nama_barang = newNama_Barang;
        }
        public Integer getQty() {
            return qty;
        }
        public void setQty(Integer newQty) {
            this.qty = newQty;
        }
        public Integer getHarga() {
            return harga;
        }
        public void setHarga(Integer newHarga) {
            this.harga = newHarga;
        }
    }

    //  INI OBJECT KUCING
    public static class Kucing {
    private String nama;
    private String warna;
    private int umur;

    public Kucing(String nama, String warna, int umur) {
        this.nama = nama;
        this.warna = warna;
        this.umur = umur;
    }

        public Kucing() {

        }


        public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}
    //   INI OBJECT ORGAN_DALAM
    static class Organdalam {
        private Integer id_organ;
        private String jenis_organ;
        private Integer jumlah_organ;

        public Organdalam(Integer id_organ, String jenis_organ, Integer jumlah_organ) {
            this.id_organ = id_organ;
            this.jenis_organ = jenis_organ;
            this.jumlah_organ = jumlah_organ;
        }

        public Organdalam() {

        }

        public Integer getId_organ() {
            return id_organ;
        }

        public void setId_organ(Integer id_organ) {
            this.id_organ = id_organ;
        }

        public String getJenis_organ() {
            return jenis_organ;
        }

        public void setJenis_organ(String jenis_organ) {
            this.jenis_organ = jenis_organ;
        }

        public Integer getJumlah_organ() {
            return jumlah_organ;
        }

        public void setJumlah_organ(Integer jumlah_organ) {
            this.jumlah_organ = jumlah_organ;
        }

    }

    //  INI OBJECT POHON
    static class Pohon {
        private String nama;
        private Boolean jenismonodiko;
        private Integer jumlahbuah;

        public Pohon (String nama, Boolean jenismonodiko, Integer jumlahbuah) {
            this.nama = nama;
            this.jenismonodiko = jenismonodiko;
            this.jumlahbuah = jumlahbuah;
        }
        public Pohon() {
        }
        public String getnama() {
            return nama;
        }
        public void setnama(String nama) {
            this.nama = nama;
        }
        public Boolean getjenismonodiko() {
            return jenismonodiko;
        }
        public void setjenismonodiko(Boolean jenismonodiko) {
            this.jenismonodiko = jenismonodiko;
        }
        public Integer getjumlahbuah() {
            return jumlahbuah;
        }
        public void setjumlahbuah(Integer jumlahbuah) {
            this.jumlahbuah = jumlahbuah;
        }
    }


    static class narasi{
        Barang id_barang;
        Pohon id_pohon;
        Kucing id_kucing;
        Organisasi id_organisasi;
        Mobil id_mobil;
        Organdalam id_organ;


        public narasi(Barang id_barang, Pohon id_pohon, Kucing id_kucing, Organisasi id_organisasi, Mobil id_mobil, Organdalam id_organ) {
            this.id_barang = id_barang;
            this.id_pohon = id_pohon;
            this.id_kucing = id_kucing;
            this.id_organisasi = id_organisasi;
            this.id_mobil = id_mobil;
            this.id_organ = id_organ;
        }

        narasi(){

        }


        public Barang getId_barang() {
            return id_barang;
        }

        public void setId_barang(Barang id_barang) {
            this.id_barang = id_barang;
        }

        public Pohon getId_pohon() {
            return id_pohon;
        }

        public void setId_pohon(Pohon id_pohon) {
            this.id_pohon = id_pohon;
        }

        public Kucing getId_kucing() {
            return id_kucing;
        }

        public void setId_kucing(Kucing id_kucing) {
            this.id_kucing = id_kucing;
        }

        public Organisasi getId_organisasi() {
            return id_organisasi;
        }

        public void setId_organisasi(Organisasi id_organisasi) {
            this.id_organisasi = id_organisasi;
        }

        public Mobil getId_mobil() {
            return id_mobil;
        }

        public void setId_mobil(Mobil id_mobil) {
            this.id_mobil = id_mobil;
        }

        public Organdalam getId_organ() {
            return id_organ;
        }

        public void setId_organ(Organdalam id_organ) {
            this.id_organ = id_organ;
        }
    }


}
