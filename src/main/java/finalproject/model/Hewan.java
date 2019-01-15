package main.java.finalproject.model;

import java.util.Objects;

public class Hewan {

    private Long idHewan;
    private String namaHewan;

    public Hewan(Long idHewan, String namaHewan) {
        this.idHewan = idHewan;
        this.namaHewan = namaHewan;
    }

    public Hewan() {
    }

    public Long getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(Long idHewan) {
        this.idHewan = idHewan;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hewan hewan = (Hewan) o;
        return Objects.equals(idHewan, hewan.idHewan) &&
                Objects.equals(namaHewan, hewan.namaHewan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHewan, namaHewan);
    }

    @Override
    public String toString() {
        return "Hewan{" +
                "idHewan=" + idHewan +
                ", namaHewan='" + namaHewan + '\'' +
                '}';
    }
}
