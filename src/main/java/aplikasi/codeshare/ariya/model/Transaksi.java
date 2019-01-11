package main.java.aplikasi.codeshare.ariya.model;
import java.util.*;
public class Transaksi {
    int id_transaksi, id_pembeli, id_motor, jumlah_pembelian;
    Date tanggal_pembelian;

    public Transaksi(){

    }

    public Transaksi(int id_transaksi, int id_pembeli, int id_motor, int jumlah_pembelian, Date tanggal_pembelian) {
        this.id_transaksi = id_transaksi;
        this.id_pembeli = id_pembeli;
        this.id_motor = id_motor;
        this.jumlah_pembelian = jumlah_pembelian;
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public int getJumlah_pembelian() {
        return jumlah_pembelian;
    }

    public void setJumlah_pembelian(int jumlah_pembelian) {
        this.jumlah_pembelian = jumlah_pembelian;
    }

    public Date getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(Date tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }


     public void outputTransaksi(){
        System.out.println("Nama Pembeli : "+getId_pembeli());
        System.out.println("Nama Motor : "+getId_motor());
        System.out.println("Tanggal Pembelian : "+getTanggal_pembelian());
        System.out.println("Jumlah Pembelian : "+getJumlah_pembelian());
    }

}
