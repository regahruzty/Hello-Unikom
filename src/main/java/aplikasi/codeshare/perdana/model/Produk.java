package main.java.aplikasi.codeshare.perdana.model;

import java.util.Objects;

public class Produk {
    Integer id_produk;
    String nama;
    String merk;
    String waktu_pembuatan;


    public Produk(Integer id_produk, String nama, String merk, String waktu_pembuatan) {
        this.id_produk = id_produk;
        this.nama = nama;
        this.merk = merk;
        this.waktu_pembuatan = waktu_pembuatan;
    }

    public Produk() {
    }

    public Integer getId_produk() {
        return id_produk;
    }

    public void setId_produk(Integer id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWaktu_pembuatan() { return waktu_pembuatan; }

    public void setWaktu_pembuatan(String waktu_pembuatan) { this.waktu_pembuatan = waktu_pembuatan; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produk produk = (Produk) o;
        return Objects.equals(id_produk, produk.id_produk) &&
                Objects.equals(nama, produk.nama) &&
                Objects.equals(merk, produk.merk) &&
                Objects.equals(waktu_pembuatan, produk.waktu_pembuatan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_produk, nama, merk, waktu_pembuatan);
    }

    @Override
    public String toString() {
        return "Produk{" +
                "id_produk=" + id_produk +
                ", nama='" + nama + '\'' +
                ", merk='" + merk + '\'' +
                ", waktu_pembuatan=" + waktu_pembuatan +
                '}';
    }
}
