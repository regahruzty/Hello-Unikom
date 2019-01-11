package main.java.aplikasi.model;

import java.util.Date;
import java.util.Objects;

// INI OBJECT Burung
public class Burung {
    //  INI VARIABEL-VARIABEL Burung
    private String nama;
    private String jenis;
    private Boolean isLiar;
    private Integer jumlahKaki;
    private Date tanggalLahir;

    //  INI ALL ARGS CONSTRUCTOR Burung
    public Burung(String nama, String jenis, Boolean isLiar, Integer jumlahKaki, Date tanggalLahir) {
        this.nama = nama;
        this.jenis = jenis;
        this.isLiar = isLiar;
        this.jumlahKaki = jumlahKaki;
        this.tanggalLahir = tanggalLahir;
    }

    //  INI NO ARGS CONSTRUCTOR Burung
    public Burung() {
    }

    //  INI METHOD GETTER SETTER OBJECT Burung
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Boolean getLiar() {
        return isLiar;
    }

    public void setLiar(Boolean liar) {
        isLiar = liar;
    }

    public Integer getJumlahKaki() {
        return jumlahKaki;
    }

    public void setJumlahKaki(Integer jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Burung burung = (Burung) o;
        return Objects.equals(nama, burung.nama) &&
                Objects.equals(jenis, burung.jenis) &&
                Objects.equals(isLiar, burung.isLiar) &&
                Objects.equals(jumlahKaki, burung.jumlahKaki) &&
                Objects.equals(tanggalLahir, burung.tanggalLahir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, jenis, isLiar, jumlahKaki, tanggalLahir);
    }
}

