package main.java.aplikasi.codeshare.gedha.model;


import java.util.Objects;

public class Komik {
    private Long id_komik;
    private String judul_komik;
    private String pengarang;
    private String tanggal_terbit;

    public Komik(Long id_komik, String judul_komik, String pengarang, String tanggal_terbit) {
        this.id_komik = id_komik;
        this.judul_komik = judul_komik;
        this.pengarang = pengarang;
        this.tanggal_terbit = tanggal_terbit;
    }

    public Komik() {
    }

    public Long getId_komik() {
        return id_komik;
    }

    public void setId_komik(Long id_komik) {
        this.id_komik = id_komik;
    }

    public String getJudul_komik() {
        return judul_komik;
    }

    public void setJudul_komik(String judul_komik) {
        this.judul_komik = judul_komik;
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
        Komik komik = (Komik) o;
        return Objects.equals(id_komik, komik.id_komik) &&
                Objects.equals(judul_komik, komik.judul_komik) &&
                Objects.equals(pengarang, komik.pengarang) &&
                Objects.equals(tanggal_terbit, komik.tanggal_terbit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_komik, judul_komik, pengarang, tanggal_terbit);
    }

    @Override
    public String toString() {
        return "Komik{" +
                "id_komik=" + id_komik +
                ", judul_komik='" + judul_komik + '\'' +
                ", pengarang='" + pengarang + '\'' +
                ", tanggal_terbit=" + tanggal_terbit +
                '}';
    }
}
