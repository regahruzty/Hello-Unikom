package main.java.aplikasi.codeshare.riyan.belajar_jdbc.model;

import java.util.Objects;

public class Pengajar {
    Integer id_pengajar;
    String nama_pengajar;
    String no_telp;
    String spesialis;

    public Pengajar(Integer id_pengajar, String nama_pengajar, String no_telp, String spesialis) {
        this.id_pengajar = id_pengajar;
        this.nama_pengajar = nama_pengajar;
        this.no_telp = no_telp;
        this.spesialis = spesialis;
    }

    public Pengajar() {
    }

    public Integer getId_pengajar() {
        return id_pengajar;
    }

    public void setId_pengajar(Integer id_pengajar) {
        this.id_pengajar = id_pengajar;
    }

    public String getNama_pengajar() {
        return nama_pengajar;
    }

    public void setNama_pengajar(String nama_pengajar) {
        this.nama_pengajar = nama_pengajar;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pengajar pengajar = (Pengajar) o;
        return Objects.equals(id_pengajar, pengajar.id_pengajar) &&
                Objects.equals(nama_pengajar, pengajar.nama_pengajar) &&
                Objects.equals(no_telp, pengajar.no_telp) &&
                Objects.equals(spesialis, pengajar.spesialis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pengajar, nama_pengajar, no_telp, spesialis);
    }

    @Override
    public String toString() {
        return "Pengajar{" +
                "id_pengajar=" + id_pengajar +
                ", nama_pengajar='" + nama_pengajar + '\'' +
                ", no_telp='" + no_telp + '\'' +
                ", spesialis='" + spesialis + '\'' +
                '}';
    }
}
