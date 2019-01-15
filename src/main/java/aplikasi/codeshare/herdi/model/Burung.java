package main.java.aplikasi.codeshare.herdi.model;

import java.util.Date;
import java.util.Objects;

public class Burung {

    private int id_burung;
    private String nama;
    private String warna;
    private String paruh;


    public Burung() {
    }

    public int getId_burung() {
        return id_burung;
    }

    public void setId_burung(int id_burung) {
        this.id_burung = id_burung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getParuh() {
        return paruh;
    }

    public void setParuh(String paruh) {
        this.paruh = paruh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burung burung = (Burung) o;
        return id_burung == burung.id_burung &&
                Objects.equals(nama, burung.nama) &&
                Objects.equals(warna, burung.warna) &&
                Objects.equals(paruh, burung.paruh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_burung, nama, warna, paruh);
    }

    @Override
    public String toString() {
        return "Burung{" +
                "id_burung=" + id_burung +
                ", nama='" + nama + '\'' +
                ", warna='" + warna + '\'' +
                ", paruh='" + paruh + '\'' +
                '}';
    }
}
