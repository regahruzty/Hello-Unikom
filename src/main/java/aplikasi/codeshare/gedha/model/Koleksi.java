package main.java.aplikasi.codeshare.gedha.model;

import java.util.Objects;

public class Koleksi {
    private Long id_koleksi;
    private Buku buku;
    private Komik komik;
    private Majalah majalah;

    public Koleksi(Long id_koleksi, Buku buku, Komik komik, Majalah majalah) {
        this.id_koleksi = id_koleksi;
        this.buku = buku;
        this.komik = komik;
        this.majalah = majalah;
    }

    public Koleksi() {
    }

    public Long getId_koleksi() {
        return id_koleksi;
    }

    public void setId_koleksi(Long id_koleksi) {
        this.id_koleksi = id_koleksi;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Komik getKomik() {
        return komik;
    }

    public void setKomik(Komik komik) {
        this.komik = komik;
    }

    public Majalah getMajalah() {
        return majalah;
    }

    public void setMajalah(Majalah majalah) {
        this.majalah = majalah;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Koleksi koleksi = (Koleksi) o;
        return Objects.equals(id_koleksi, koleksi.id_koleksi) &&
                Objects.equals(buku, koleksi.buku) &&
                Objects.equals(komik, koleksi.komik) &&
                Objects.equals(majalah, koleksi.majalah);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_koleksi, buku, komik, majalah);
    }

    @Override
    public String toString() {
        return "Koleksi{" +
                "id_koleksi=" + id_koleksi +
                ", buku=" + buku +
                ", komik=" + komik +
                ", majalah=" + majalah +
                '}';
    }
}
