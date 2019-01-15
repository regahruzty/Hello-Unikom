package main.java.aplikasi.codeshare.puti.FinalProject.model;

import java.util.Objects;

public class Barang {
    private Long idBarang;
    private String namaBarang;

    public Barang(Long idBarang, String namaBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
    }

    public Barang() {

    }

    public Long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Long idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barang barang = (Barang) o;
        return Objects.equals(idBarang, barang.idBarang) &&
                Objects.equals(namaBarang, barang.namaBarang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBarang, namaBarang);
    }

    @Override
    public String toString() {
        return "Barang{" +
                "idBarang=" + idBarang +
                ", namaBarang='" + namaBarang + '\'' +
                '}';
    }
}
