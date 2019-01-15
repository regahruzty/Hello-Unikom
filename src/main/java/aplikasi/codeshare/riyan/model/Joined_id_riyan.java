package main.java.aplikasi.codeshare.riyan.model;

import java.util.Objects;

public class Joined_id_riyan {
    private Long id_joined_riyan;
    private Boothcamp boothcamp;
    private Pengajar pengajar;
    private Peserta peserta;

    public Joined_id_riyan(Long id_joined_riyan, Boothcamp boothcamp, Pengajar pengajar, Peserta peserta) {
        this.id_joined_riyan = id_joined_riyan;
        this.boothcamp = boothcamp;
        this.pengajar = pengajar;
        this.peserta = peserta;
    }

    public Joined_id_riyan() {
    }

    public Long getId_joined_riyan() {
        return id_joined_riyan;
    }

    public void setId_joined_riyan(Long id_joined_riyan) {
        this.id_joined_riyan = id_joined_riyan;
    }

    public Boothcamp getBoothcamp() {
        return boothcamp;
    }

    public void setBoothcamp(Boothcamp boothcamp) {
        this.boothcamp = boothcamp;
    }

    public Pengajar getPengajar() {
        return pengajar;
    }

    public void setPengajar(Pengajar pengajar) {
        this.pengajar = pengajar;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public void setPeserta(Peserta peserta) {
        this.peserta = peserta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joined_id_riyan that = (Joined_id_riyan) o;
        return Objects.equals(id_joined_riyan, that.id_joined_riyan) &&
                Objects.equals(boothcamp, that.boothcamp) &&
                Objects.equals(pengajar, that.pengajar) &&
                Objects.equals(peserta, that.peserta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_joined_riyan, boothcamp, pengajar, peserta);
    }

    @Override
    public String toString() {
        return "Joined_id_riyan{" +
                "id_joined_riyan=" + id_joined_riyan +
                ", boothcamp=" + boothcamp +
                ", pengajar=" + pengajar +
                ", peserta=" + peserta +
                '}';
    }
}