package main.java.aplikasi.codeshare.azizan.Model;

import java.util.Date;
import java.util.Objects;

public class Tentara {
    private String nama;
    private String pangkat;
    private String matra;
    private int id;
    private boolean isPerwira;
    private Date tanggal_lahir;

    public Tentara(String nama, String pangkat, String matra, int id, boolean isPerwira, Date tanggal_lahir) {
        this.nama = nama;
        this.pangkat = pangkat;
        this.matra = matra;
        this.id = id;
        this.isPerwira = isPerwira;
        this.tanggal_lahir = tanggal_lahir;
    }

    public Tentara() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getMatra() {
        return matra;
    }

    public void setMatra(String matra) {
        this.matra = matra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPerwira() {
        return isPerwira;
    }

    public void setPerwira(boolean perwira) {
        isPerwira = perwira;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tentara tentara = (Tentara) o;
        return isPerwira == tentara.isPerwira &&
                Objects.equals(nama, tentara.nama) &&
                Objects.equals(pangkat, tentara.pangkat) &&
                Objects.equals(matra, tentara.matra) &&
                Objects.equals(id, tentara.id) &&
                Objects.equals(tanggal_lahir, tentara.tanggal_lahir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, pangkat, matra, id, isPerwira, tanggal_lahir);
    }
}

