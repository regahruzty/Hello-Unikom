package main.java.aplikasi.codeshare.azizan.Model;

import java.util.Objects;

public class TentaraAktif {
    private int id;
    private int id_tentara;

    public TentaraAktif(int id, int id_tentara) {
        this.id = id;
        this.id_tentara = id_tentara;
    }

    public TentaraAktif(){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TentaraAktif that = (TentaraAktif) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(id_tentara, that.id_tentara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_tentara);
    }
}
