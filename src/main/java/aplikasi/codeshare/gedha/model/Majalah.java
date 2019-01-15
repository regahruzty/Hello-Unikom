package main.java.aplikasi.codeshare.gedha.model;


import java.util.Objects;

public class Majalah {
    private Long id_majalah;
    private String judul_majalah;
    private String pengarang;
    private String tanggal_terbit;

    public Majalah(Long id_majalah, String judul_majalah, String pengarang, String tanggal_terbit) {
        this.id_majalah = id_majalah;
        this.judul_majalah = judul_majalah;
        this.pengarang = pengarang;
        this.tanggal_terbit = tanggal_terbit;
    }

    public Majalah() {
    }

    public Long getId_majalah() {
        return id_majalah;
    }

    public void setId_majalah(Long id_majalah) {
        this.id_majalah = id_majalah;
    }

    public String getJudul_majalah() {
        return judul_majalah;
    }

    public void setJudul_majalah(String judul_majalah) {
        this.judul_majalah = judul_majalah;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getTanggal_terbit() {
        return tanggal_terbit;
    }

    public void setTanggal_terbit(String tanggal_terbit) {
        this.tanggal_terbit = tanggal_terbit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Majalah majalah = (Majalah) o;
        return Objects.equals(id_majalah, majalah.id_majalah) &&
                Objects.equals(judul_majalah, majalah.judul_majalah) &&
                Objects.equals(pengarang, majalah.pengarang) &&
                Objects.equals(tanggal_terbit, majalah.tanggal_terbit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_majalah, judul_majalah, pengarang, tanggal_terbit);
    }

    @Override
    public String toString() {
        return "Majalah{" +
                "id_majalah=" + id_majalah +
                ", judul_majalah='" + judul_majalah + '\'' +
                ", pengarang='" + pengarang + '\'' +
                ", tanggal_terbit=" + tanggal_terbit +
                '}';
    }
}
