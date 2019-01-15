package main.java.aplikasi.codeshare.ariya.ariya_final.model;

import java.util.Objects;

public class Motor {
    private Long id_motor;
    private String nama_motor;
    private String merk_motor;

    public Motor(Long id_motor, String nama_motor, String merk_motor) {
        this.id_motor = id_motor;
        this.nama_motor = nama_motor;
        this.merk_motor = merk_motor;
    }

    public Motor() {
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id_motor=" + id_motor +
                ", nama_motor='" + nama_motor + '\'' +
                ", merk_motor='" + merk_motor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor = (Motor) o;
        return Objects.equals(id_motor, motor.id_motor) &&
                Objects.equals(nama_motor, motor.nama_motor) &&
                Objects.equals(merk_motor, motor.merk_motor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_motor, nama_motor, merk_motor);
    }

    public Long getId_motor() {
        return id_motor;
    }

    public void setId_motor(Long id_motor) {
        this.id_motor = id_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }

    public String getMerk_motor() {
        return merk_motor;
    }

    public void setMerk_motor(String merk_motor) {
        this.merk_motor = merk_motor;
    }
}
