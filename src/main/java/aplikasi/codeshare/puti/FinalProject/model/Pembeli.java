package main.java.aplikasi.codeshare.puti.FinalProject.model;

import java.util.Objects;

public class Pembeli {
    private Long idPembeli;
    private String namaPembeli;

    public Pembeli(Long idPembeli, String namaPembeli) {
        this.idPembeli = idPembeli;
        this.namaPembeli = namaPembeli;
    }

    public Pembeli() {
    }

    public Long getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(Long idPembeli) {
        this.idPembeli = idPembeli;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pembeli pembeli = (Pembeli) o;
        return Objects.equals(idPembeli, pembeli.idPembeli) &&
                Objects.equals(namaPembeli, pembeli.namaPembeli);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPembeli, namaPembeli);
    }

    @Override
    public String toString() {
        return "Pembeli{" +
                "idPembeli=" + idPembeli +
                ", namaPembeli='" + namaPembeli + '\'' +
                '}';
    }
}
