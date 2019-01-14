package main.java.aplikasi.codeshare.ariya.model;
public class Motor {

    String merk_motor, nama_motor;
    int id_motor, harga;

    public Motor(){

    }

    public Motor(String merk_motor, String nama_motor, int id_motor, int harga) {
        this.merk_motor = merk_motor;
        this.nama_motor = nama_motor;
        this.id_motor = id_motor;
        this.harga = harga;
    }



    public String getMerk_motor() {
        return merk_motor;
    }

    public void setMerk_motor(String merk_motor) {
        this.merk_motor = merk_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

}
