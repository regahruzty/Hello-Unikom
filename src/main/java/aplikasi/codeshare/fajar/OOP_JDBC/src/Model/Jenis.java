package main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Model;

import java.util.Objects;

public class Jenis {
    private int id_jenis;
    private String jenis_obat;
    private String keterangan;

    public Jenis(int id_jenis, String jenis_obat, String keterangan) {
        this.id_jenis = id_jenis;
        this.jenis_obat = jenis_obat;
        this.keterangan = keterangan;
    }

    public Jenis() {
    }

    public int getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(int id_jenis) {
        this.id_jenis = id_jenis;
    }

    public String getJenis_obat() {
        return jenis_obat;
    }

    public void setJenis_obat(String jenis_obat) {
        this.jenis_obat = jenis_obat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jenis Jenis = (Jenis) o;
        return id_jenis == Jenis.id_jenis &&
                Objects.equals(jenis_obat, Jenis.jenis_obat) &&
                Objects.equals(keterangan, Jenis.keterangan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jenis, jenis_obat, keterangan);
    }

    @Override
    public String toString() {
        return "Jenis{" +
                "id_jenis=" + id_jenis +
                ", jenis_obat='" + jenis_obat + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
