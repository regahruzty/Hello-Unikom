package main.java.aplikasi.codeshare.puti.FinalProject.model;

import java.util.Objects;

public class Faktur {
    private Long idFaktur;
    private Barang barang;
    private Pembeli pembeli;

    public Faktur(Long idFaktur, Barang barang, Pembeli pembeli) {
        this.idFaktur = idFaktur;
        this.barang = barang;
        this.pembeli = pembeli;
    }

    public Faktur() {
    }

    public Long getIdFaktur() {
        return idFaktur;
    }

    public void setIdFaktur(Long idFaktur) {
        this.idFaktur = idFaktur;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faktur faktur = (Faktur) o;
        return idFaktur.equals(faktur.idFaktur) &&
                barang.equals(faktur.barang) &&
                pembeli.equals(faktur.pembeli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFaktur, barang, pembeli);
    }

    @Override
    public String toString() {
        return "Faktur{" +
                "idFaktur=" + idFaktur +
                ", barang=" + barang +
                ", pembeli=" + pembeli +
                '}';
    }
}
