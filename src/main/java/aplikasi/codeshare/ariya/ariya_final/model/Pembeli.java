package main.java.aplikasi.codeshare.ariya.ariya_final.model;

import java.util.Objects;

public class Pembeli {

    private Long id_pembeli;
    private String nama_pembeli;
    private String alamat_pembeli;

    public Pembeli() {
    }

    @Override
    public String toString() {
        return "Pembeli{" +
                "id_pembeli=" + id_pembeli +
                ", nama_pembeli='" + nama_pembeli + '\'' +
                ", alamat_pembeli='" + alamat_pembeli + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pembeli pembeli = (Pembeli) o;
        return id_pembeli.equals(pembeli.id_pembeli) &&
                nama_pembeli.equals(pembeli.nama_pembeli) &&
                alamat_pembeli.equals(pembeli.alamat_pembeli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pembeli, nama_pembeli, alamat_pembeli);
    }

    public Long getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(Long id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getAlamat_pembeli() {
        return alamat_pembeli;
    }

    public void setAlamat_pembeli(String alamat_pembeli) {
        this.alamat_pembeli = alamat_pembeli;
    }

    public Pembeli(Long id_pembeli, String nama_pembeli, String alamat_pembeli) {
        this.id_pembeli = id_pembeli;
        this.nama_pembeli = nama_pembeli;
        this.alamat_pembeli = alamat_pembeli;
    }
}
