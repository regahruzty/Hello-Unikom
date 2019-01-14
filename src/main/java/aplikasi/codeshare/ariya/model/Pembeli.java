package main.java.aplikasi.codeshare.ariya.model;
public class Pembeli {

    String nama_pembeli, pekerjaan, alamat;
    int id_pembeli;

    public Pembeli(){

    }

    public Pembeli(String nama_pembeli, String pekerjaan, String alamat, int id_pembeli) {
        this.nama_pembeli = nama_pembeli;
        this.pekerjaan = pekerjaan;
        this.alamat = alamat;
        this.id_pembeli = id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

}
