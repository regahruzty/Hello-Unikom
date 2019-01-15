package main.java.aplikasi.codeshare.herdi.model;

import java.util.Objects;

public class JoinedHerdi {
    private int id_joined_herdi;
    private Burung burung;
    private Jenis jenis;
    private Sifat sifat;


    public JoinedHerdi() {
    }

    public int getId_joined_herdi() {
        return id_joined_herdi;
    }

    public void setId_joined_herdi(int id_joined_herdi) {
        this.id_joined_herdi = id_joined_herdi;
    }

    public Burung getBurung() {
        return burung;
    }

    public void setBurung(Burung burung) {
        this.burung = burung;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

    public Sifat getSifat() {
        return sifat;
    }

    public void setSifat(Sifat sifat) {
        this.sifat = sifat;
    }
}
