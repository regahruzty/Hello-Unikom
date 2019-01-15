package main.java.aplikasi.codeshare.ariya.ariya_final.model;

import java.util.Date;
import java.util.Objects;

public class Transaksi {

    private Long id_transaksi;
    private Pembeli pembeli;
    private Motor motor;
    private Date tanggal_pembelian;
    private Long jumlah_pembelian;

    public Transaksi(Long id_transaksi, Pembeli pembeli, Motor motor, Date tanggal_pembelian, Long jumlah_pembelian) {
        this.id_transaksi = id_transaksi;
        this.pembeli = pembeli;
        this.motor = motor;
        this.tanggal_pembelian = tanggal_pembelian;
        this.jumlah_pembelian = jumlah_pembelian;
    }

    public Transaksi() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaksi transaksi = (Transaksi) o;
        return id_transaksi.equals(transaksi.id_transaksi) &&
                pembeli.equals(transaksi.pembeli) &&
                motor.equals(transaksi.motor) &&
                tanggal_pembelian.equals(transaksi.tanggal_pembelian) &&
                jumlah_pembelian.equals(transaksi.jumlah_pembelian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_transaksi, pembeli, motor, tanggal_pembelian, jumlah_pembelian);
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "id_transaksi=" + id_transaksi +
                ", pembeli=" + pembeli +
                ", motor=" + motor +
                ", tanggal_pembelian=" + tanggal_pembelian +
                ", jumlah_pembelian=" + jumlah_pembelian +
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

    public Date getTanggal_pembelian() {
        return tanggal_pembelian;
    }

    public void setTanggal_pembelian(Date tanggal_pembelian) {
        this.tanggal_pembelian = tanggal_pembelian;
    }

    public Long getJumlah_pembelian() {
        return jumlah_pembelian;
    }

    public void setJumlah_pembelian(Long jumlah_pembelian) {
        this.jumlah_pembelian = jumlah_pembelian;
    }
}
