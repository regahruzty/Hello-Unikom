package main.java.aplikasi.codeshare.azizan.TNI.Model;

import java.util.Objects;

public class Batalyon {
    private Long idBayalyon;
    private String namaBatalyon;

    public Batalyon(Long idBayalyon, String namaBatalyon) {
        this.idBayalyon = idBayalyon;
        this.namaBatalyon = namaBatalyon;
    }

    public Batalyon(){

    }

    public Long getIdBayalyon() {
        return idBayalyon;
    }

    public void setIdBayalyon(Long idBayalyon) {
        this.idBayalyon = idBayalyon;
    }

    public String getNamaBatalyon() {
        return namaBatalyon;
    }

    public void setNamaBatalyon(String namaBatalyon) {
        this.namaBatalyon = namaBatalyon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batalyon batalyon = (Batalyon) o;
        return Objects.equals(idBayalyon, batalyon.idBayalyon) &&
                Objects.equals(namaBatalyon, batalyon.namaBatalyon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBayalyon, namaBatalyon);
    }

    @Override
    public String toString() {
        return "Batalyon{" +
                "idBayalyon=" + idBayalyon +
                ", namaBatalyon='" + namaBatalyon + '\'' +
                '}';
    }
}