package main.java.aplikasi.codeshare.ariya.ariya_final.model;

import java.util.Objects;

public class Transaksi {

    private Long id_transaksi;
    private Pembeli pembeli;
    private Motor motor;

    public Transaksi() {
    }

    public Transaksi(Long id_transaksi, Pembeli pembeli, Motor motor) {
        this.id_transaksi = id_transaksi;
        this.pembeli = pembeli;
        this.motor = motor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaksi transaksi = (Transaksi) o;
        return id_transaksi.equals(transaksi.id_transaksi) &&
                pembeli.equals(transaksi.pembeli) &&
                motor.equals(transaksi.motor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_transaksi, pembeli, motor);
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "id_transaksi=" + id_transaksi +
                ", pembeli=" + pembeli +
                ", motor=" + motor +
                '}';
    }

    public Long getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Long id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Pembeli getPembeli() {
        return pembeli;
    }

    public void setPembeli(Pembeli pembeli) {
        this.pembeli = pembeli;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
}
