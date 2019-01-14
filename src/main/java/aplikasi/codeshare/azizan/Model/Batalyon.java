package main.java.aplikasi.codeshare.azizan.Model;

import java.util.Objects;

public class Batalyon {
    private int id;
    private int id_tentara;
    private String jabatan;

    public Batalyon(int id, int id_tentara, String jabatan) {
        this.id = id;
        this.id_tentara = id_tentara;
        this.jabatan = jabatan;
    }

    public Batalyon(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tentara() {
        return id_tentara;
    }

    public void setId_tentara(int id_tentara) {
        this.id_tentara = id_tentara;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batalyon batalyon = (Batalyon) o;
        return id == batalyon.id &&
                id_tentara == batalyon.id_tentara &&
                Objects.equals(jabatan, batalyon.jabatan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_tentara, jabatan);
    }
}
