package Model;

import java.sql.Date;
import java.util.Objects;

public class Obat {
    private int id_obat;
    private String nama_obat;
    private Date tgl_kadarluarsa;

    public Obat(int id_obat, String nama_obat, Date tgl_kadarluarsa) {
        this.id_obat = id_obat;
        this.nama_obat = nama_obat;
        this.tgl_kadarluarsa = tgl_kadarluarsa;
    }

    public Obat() {
    }

    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public java.sql.Date getTgl_kadarluarsa() {
        return tgl_kadarluarsa;
    }

    public void setTgl_kadarluarsa(Date tgl_kadarluarsa) {
        this.tgl_kadarluarsa = tgl_kadarluarsa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obat obat = (Obat) o;
        return id_obat == obat.id_obat &&
                Objects.equals(nama_obat, obat.nama_obat) &&
                Objects.equals(tgl_kadarluarsa, obat.tgl_kadarluarsa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_obat, nama_obat, tgl_kadarluarsa);
    }

    @Override
    public String toString() {
        return "Obat{" +
                "id_obat=" + id_obat +
                ", nama_obat='" + nama_obat + '\'' +
                ", tgl_kadarluarsa=" + tgl_kadarluarsa +
                '}';
    }
}