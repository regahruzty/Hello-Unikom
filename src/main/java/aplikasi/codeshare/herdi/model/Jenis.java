package main.java.aplikasi.codeshare.herdi.model;

import java.util.Objects;

public class Jenis {
    private int id_jenis;
    private String jenis;
    private String desc_jenis;

    public Jenis() {
    }

    public int getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(int id_jenis) {
        this.id_jenis = id_jenis;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDesc_jenis() {
        return desc_jenis;
    }

    public void setDesc_jenis(String desc_jenis) {
        this.desc_jenis = desc_jenis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jenis jenis1 = (Jenis) o;
        return id_jenis == jenis1.id_jenis &&
                Objects.equals(jenis, jenis1.jenis) &&
                Objects.equals(desc_jenis, jenis1.desc_jenis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jenis, jenis, desc_jenis);
    }

    @Override
    public String toString() {
        return "Jenis{" +
                "id_jenis=" + id_jenis +
                ", jenis='" + jenis + '\'' +
                ", desc_jenis='" + desc_jenis + '\'' +
                '}';
    }
}
