package main.java.finalproject.model;

import java.util.Objects;

public class Tumbuhan {

    private Long idTumbuhan;
    private String namaTumbuhan;

    public Tumbuhan(Long idTumbuhan, String namaTumbuhan) {
        this.idTumbuhan = idTumbuhan;
        this.namaTumbuhan = namaTumbuhan;
    }

    public Tumbuhan() {
    }

    public Long getIdTumbuhan() {
        return idTumbuhan;
    }

    public void setIdTumbuhan(Long idTumbuhan) {
        this.idTumbuhan = idTumbuhan;
    }

    public String getNamaTumbuhan() {
        return namaTumbuhan;
    }

    public void setNamaTumbuhan(String namaTumbuhan) {
        this.namaTumbuhan = namaTumbuhan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tumbuhan tumbuhan = (Tumbuhan) o;
        return Objects.equals(idTumbuhan, tumbuhan.idTumbuhan) &&
                Objects.equals(namaTumbuhan, tumbuhan.namaTumbuhan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTumbuhan, namaTumbuhan);
    }

    @Override
    public String toString() {
        return "Tumbuhan{" +
                "idTumbuhan=" + idTumbuhan +
                ", namaTumbuhan='" + namaTumbuhan + '\'' +
                '}';
    }
}
