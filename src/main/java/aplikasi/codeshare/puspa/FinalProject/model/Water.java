package main.java.aplikasi.codeshare.puspa.FinalProject.model;

import java.util.Objects;

public class Water {
    private Long idWater;
    private String namaWater;

    public Water(Long idWater, String namaWater) {
        this.idWater = idWater;
        this.namaWater = namaWater;
    }

    public Water() {
    }

    public Long getIdWater() {
        return idWater;
    }

    public void setIdWater(Long idWater) {
        this.idWater = idWater;
    }

    public String getNamaWater() {
        return namaWater;
    }

    public void setNamaWater(String namaWater) {
        this.namaWater = namaWater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Water water = (Water) o;
        return Objects.equals(idWater, water.idWater) &&
                Objects.equals(namaWater, water.namaWater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWater, namaWater);
    }

    @Override
    public String toString() {
        return "Water{" +
                "idWater=" + idWater +
                ", namaWater='" + namaWater + '\'' +
                '}';
    }
}
