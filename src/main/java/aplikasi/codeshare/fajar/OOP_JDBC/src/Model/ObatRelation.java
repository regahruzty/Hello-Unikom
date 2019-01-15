package Model;

import java.util.Objects;

public class ObatRelation {
    private int id_relation;
    private Dosis id_dosis;
    private Obat id_obat;
    private Jenis id_jenis;

    public ObatRelation(int id_relation, Dosis id_dosis, Obat id_obat, Jenis id_jenis) {
        this.id_relation = id_relation;
        this.id_dosis = id_dosis;
        this.id_obat = id_obat;
        this.id_jenis = id_jenis;
    }

    public ObatRelation() {
    }

    public int getId_relation() {
        return id_relation;
    }

    public void setId_relation(int id_relation) {
        this.id_relation = id_relation;
    }

    public Dosis getId_dosis() {
        return id_dosis;
    }

    public void setId_dosis(Dosis id_dosis) {
        this.id_dosis = id_dosis;
    }

    public Obat getId_obat() {
        return id_obat;
    }

    public void setId_obat(Obat id_obat) {
        this.id_obat = id_obat;
    }

    public Jenis getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(Jenis id_jenis) {
        this.id_jenis = id_jenis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObatRelation that = (ObatRelation) o;
        return id_relation == that.id_relation &&
                Objects.equals(id_dosis, that.id_dosis) &&
                Objects.equals(id_obat, that.id_obat) &&
                Objects.equals(id_jenis, that.id_jenis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_relation, id_dosis, id_obat, id_jenis);
    }

    @Override
    public String toString() {
        return "ObatRelation{" +
                "id_relation=" + id_relation +
                ", id_dosis=" + id_dosis +
                ", id_obat=" + id_obat +
                ", id_jenis=" + id_jenis +
                '}';
    }
}
