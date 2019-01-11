package main.java.aplikasi.model;

import java.util.Date;
import java.util.Objects;

// INI OBJECT KUCING
public class Kucing {
    //  INI VARIABEL-VARIABEL KUCING
    private String nama;
    private String jenis;
    private Boolean isLiar;
    private Integer jumlahKaki;
    private Date tanggalLahir;

    //  INI ALL ARGS CONSTRUCTOR KUCING
    public Kucing(String nama, String jenis, Boolean isLiar, Integer jumlahKaki, Date tanggalLahir) {
        this.nama = nama;
        this.jenis = jenis;
        this.isLiar = isLiar;
        this.jumlahKaki = jumlahKaki;
        this.tanggalLahir = tanggalLahir;
    }

    //  INI NO ARGS CONSTRUCTOR KUCING
    public Kucing() {
    }

    //  INI METHOD GETTER SETTER OBJECT KUCING
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
        Kucing kucing = (Kucing) o;
        return Objects.equals(nama, kucing.nama) &&
                Objects.equals(jenis, kucing.jenis) &&
                Objects.equals(isLiar, kucing.isLiar) &&
                Objects.equals(jumlahKaki, kucing.jumlahKaki) &&
                Objects.equals(tanggalLahir, kucing.tanggalLahir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, jenis, isLiar, jumlahKaki, tanggalLahir);
    }
}
