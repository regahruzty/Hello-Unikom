package main.java.aplikasi.codeshare.riyan.belajar_jdbc.model;

import java.util.Objects;

public class Peserta {
    Integer id_peserta;
    String nama_peserta;
    String no_telp;
    String alamat;

    public Peserta(Integer id_peserta, String nama_peserta, String no_telp, String alamat) {
        this.id_peserta = id_peserta;
        this.nama_peserta = nama_peserta;
        this.no_telp = no_telp;
        this.alamat = alamat;
    }

    public Peserta() {
    }

    public Integer getId_peserta() {
        return id_peserta;
    }

    public void setId_peserta(Integer id_peserta) {
        this.id_peserta = id_peserta;
    }

    public String getNama_peserta() {
        return nama_peserta;
    }

    public void setNama_peserta(String nama_peserta) {
        this.nama_peserta = nama_peserta;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peserta peserta = (Peserta) o;
        return Objects.equals(id_peserta, peserta.id_peserta) &&
                Objects.equals(nama_peserta, peserta.nama_peserta) &&
                Objects.equals(no_telp, peserta.no_telp) &&
                Objects.equals(alamat, peserta.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_peserta, nama_peserta, no_telp, alamat);
    }

    @Override
    public String toString() {
        return "Peserta{" +
                "id_peserta=" + id_peserta +
                ", nama_peserta='" + nama_peserta + '\'' +
                ", no_telp='" + no_telp + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
