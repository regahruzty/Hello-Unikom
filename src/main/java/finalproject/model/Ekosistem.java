package main.java.finalproject.model;

import java.util.Objects;

public class Ekosistem {

    private Long idEkosistem;
    private Hewan hewan;
    private Tumbuhan tumbuhan;

    public Ekosistem(Long idEkosistem, Hewan hewan, Tumbuhan tumbuhan) {
        this.idEkosistem = idEkosistem;
        this.hewan = hewan;
        this.tumbuhan = tumbuhan;
    }

    public Ekosistem() {
    }

    public Long getIdEkosistem() {
        return idEkosistem;
    }

    public void setIdEkosistem(Long idEkosistem) {
        this.idEkosistem = idEkosistem;
    }

    public Hewan getHewan() {
        return hewan;
    }

    public void setHewan(Hewan hewan) {
        this.hewan = hewan;
    }

    public Tumbuhan getTumbuhan() {
        return tumbuhan;
    }

    public void setTumbuhan(Tumbuhan tumbuhan) {
        this.tumbuhan = tumbuhan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ekosistem ekosistem = (Ekosistem) o;
        return Objects.equals(idEkosistem, ekosistem.idEkosistem) &&
                Objects.equals(hewan, ekosistem.hewan) &&
                Objects.equals(tumbuhan, ekosistem.tumbuhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEkosistem, hewan, tumbuhan);
    }

    @Override
    public String toString() {
        return "Ekosistem{" +
                "idEkosistem=" + idEkosistem +
                ", hewan=" + hewan +
                ", tumbuhan=" + tumbuhan +
                '}';
    }
}

