package main.java.aplikasi.codeshare.gedha.model;


import java.util.Objects;

public class Buku {
    private Long id_buku;
    private String judul_buku;
    private String pengarang;
    private String tanggal_terbit;

    public Buku(Long id_buku, String judul_buku, String pengarang, String tanggal_terbit) {
        this.id_buku = id_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tanggal_terbit = tanggal_terbit;
    }

    public Buku() {
    }

    public Long getId_buku() {
        return id_buku;
    }

    public void setId_buku(Long id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
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
        Buku buku = (Buku) o;
        return Objects.equals(id_buku, buku.id_buku) &&
                Objects.equals(judul_buku, buku.judul_buku) &&
                Objects.equals(pengarang, buku.pengarang) &&
                Objects.equals(tanggal_terbit, buku.tanggal_terbit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_buku, judul_buku, pengarang, tanggal_terbit);
    }

    @Override
    public String toString() {
        return "Buku{" +
                "id_buku=" + id_buku +
                ", judul_buku='" + judul_buku + '\'' +
                ", pengarang='" + pengarang + '\'' +
                ", tanggal_terbit=" + tanggal_terbit +
                '}';
    }
}
