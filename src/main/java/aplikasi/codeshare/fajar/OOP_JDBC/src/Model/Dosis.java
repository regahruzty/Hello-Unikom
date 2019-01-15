package main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Model;

import java.util.Objects;

public class Dosis {
    private int id_dosis;
    private String dosis;
    private String keterangan;


    public Dosis(int id_dosis, String dosis, String keterangan) {
        this.id_dosis = id_dosis;
        this.dosis = dosis;
        this.keterangan = keterangan;
    }

    public Dosis() {
    }

    public int getId_dosis() {
        return id_dosis;
    }

    public void setId_dosis(int id_dosis) {
        this.id_dosis = id_dosis;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosis dosis1 = (Dosis) o;
        return id_dosis == dosis1.id_dosis &&
                Objects.equals(dosis, dosis1.dosis) &&
                Objects.equals(keterangan, dosis1.keterangan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_dosis, dosis, keterangan);
    }

    @Override
    public String toString() {
        return "Dosis{" +
                "id_dosis=" + id_dosis +
                ", dosis='" + dosis + '\'' +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
