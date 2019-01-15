package main.java.aplikasi.codeshare.perdana.model;

import java.util.Objects;

public class Jenis {
    Integer id_jenis;
    String jenis;
    String keterangan;


    public Jenis(Integer id_jenis, String jenis, String keterangan) {
        this.id_jenis = id_jenis;
        this.jenis = jenis;
        this.keterangan = keterangan;
    }

    public Jenis() {
    }

    public Integer getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(Integer id_jenis) {
        this.id_jenis = id_jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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
        Jenis jenis1 = (Jenis) o;
        return Objects.equals(id_jenis, jenis1.id_jenis) &&
                Objects.equals(jenis, jenis1.jenis) &&
                Objects.equals(keterangan, jenis1.keterangan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jenis, jenis, keterangan);
    }

    @Override
    public String toString() {
        return "Jenis{" +
                "id_jenis=" + id_jenis +
                ", jenis='" + jenis + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
