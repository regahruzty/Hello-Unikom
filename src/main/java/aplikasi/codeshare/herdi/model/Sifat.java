package main.java.aplikasi.codeshare.herdi.model;

import java.util.Objects;

public class Sifat {
    private int id_sifat;
    private String sifat;
    private String desc_sifat;

    public Sifat() {
    }

    public int getId_sifat() {
        return id_sifat;
    }

    public void setId_sifat(int id_sifat) {
        this.id_sifat = id_sifat;
    }

    public String getSifat() {
        return sifat;
    }

    public void setSifat(String sifat) {
        this.sifat = sifat;
    }

    public String getDesc_sifat() {
        return desc_sifat;
    }

    public void setDesc_sifat(String desc_sifat) {
        this.desc_sifat = desc_sifat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sifat sifat1 = (Sifat) o;
        return id_sifat == sifat1.id_sifat &&
                Objects.equals(sifat, sifat1.sifat) &&
                Objects.equals(desc_sifat, sifat1.desc_sifat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_sifat, sifat, desc_sifat);
    }

    @Override
    public String toString() {
        return "Sifat{" +
                "id_sifat=" + id_sifat +
                ", sifat='" + sifat + '\'' +
                ", desc_sifat='" + desc_sifat + '\'' +
                '}';
    }
}
