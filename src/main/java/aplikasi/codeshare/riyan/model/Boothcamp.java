package main.java.aplikasi.codeshare.riyan.model;

import java.util.Objects;

public class Boothcamp {
    Integer id_boothcamp;
    String nama_boothcamp;
    String lokasi;
    String alamat;

    public Boothcamp(Integer id_boothcamp, String nama_boothcamp, String lokasi, String alamat) {
        this.id_boothcamp = id_boothcamp;
        this.nama_boothcamp = nama_boothcamp;
        this.lokasi = lokasi;
        this.alamat = alamat;
    }

    public Boothcamp() {
    }

    public Integer getId_boothcamp() {
        return id_boothcamp;
    }

    public void setId_boothcamp(Integer id_boothcamp) {
        this.id_boothcamp = id_boothcamp;
    }

    public String getNama_boothcamp() {
        return nama_boothcamp;
    }

    public void setNama_boothcamp(String nama_boothcamp) {
        this.nama_boothcamp = nama_boothcamp;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
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
        Boothcamp boothcamp = (Boothcamp) o;
        return Objects.equals(id_boothcamp, boothcamp.id_boothcamp) &&
                Objects.equals(nama_boothcamp, boothcamp.nama_boothcamp) &&
                Objects.equals(lokasi, boothcamp.lokasi) &&
                Objects.equals(alamat, boothcamp.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_boothcamp, nama_boothcamp, lokasi, alamat);
    }

    @Override
    public String toString() {
        return "Boothcamp{" +
                "id_boothcamp=" + id_boothcamp +
                ", nama_boothcamp='" + nama_boothcamp + '\'' +
                ", lokasi='" + lokasi + '\'' +
                ", alamat='" + alamat + '\'' +
                '}';
    }
}
