package main.java.aplikasi.codeshare.puspa.FinalProject.model;

import java.util.Objects;

public class Fire {

    private Long idFire;
    private String namaFire;

    public Fire(Long idFire, String namaFire) {
        this.idFire = idFire;
        this.namaFire = namaFire;
    }

    public Fire() {
    }

    public Long getIdFire() {
        return idFire;
    }

    public void setIdFire(Long idFire) {
        this.idFire = idFire;
    }

    public String getNamaFire() {
        return namaFire;
    }

    public void setNamaFire(String namaFire) {
        this.namaFire = namaFire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fire fire = (Fire) o;
        return Objects.equals(idFire, fire.idFire) &&
                Objects.equals(namaFire, fire.namaFire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFire, namaFire);
    }

    @Override
    public String toString() {
        return "Fire{" +
                "idFire=" + idFire +
                ", namaFire='" + namaFire + '\'' +
                '}';
    }
}
