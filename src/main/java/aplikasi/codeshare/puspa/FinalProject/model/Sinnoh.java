package main.java.aplikasi.codeshare.puspa.FinalProject.model;

import java.util.Objects;

public class Sinnoh {
    private Long idSinnoh;
    private Fire fire;
    private Water water;

    public Sinnoh(Long idSinnoh, Fire fire, Water water) {
        this.idSinnoh = idSinnoh;
        this.fire = fire;
        this.water = water;
    }

    public Sinnoh() {
    }

    public Long getIdSinnoh() {
        return idSinnoh;
    }

    public void setIdSinnoh(Long idSinnoh) {
        this.idSinnoh = idSinnoh;
    }

    public Fire getFire() {
        return fire;
    }

    public void setFire(Fire fire) {
        this.fire = fire;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinnoh sinnoh = (Sinnoh) o;
        return Objects.equals(idSinnoh, sinnoh.idSinnoh) &&
                Objects.equals(fire, sinnoh.fire) &&
                Objects.equals(water, sinnoh.water);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSinnoh, fire, water);
    }

    @Override
    public String toString() {
        return "Sinnoh{" +
                "idSinnoh=" + idSinnoh +
                ", fire=" + fire +
                ", water=" + water +
                '}';
    }

}
