package main.java.aplikasi.codeshare.azizan.Model;

import java.util.Objects;

public class Tentara {
    private String nama;
    private String pangkat;
    private String matra;
    private Long id;

    private Tentara(String nama, String pangkat, String matra) {
        this.nama = nama;
        this.pangkat = pangkat;
        this.matra = matra;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tentara tentara = (Tentara) o;
        return Objects.equals(nama, tentara.nama) &&
                Objects.equals(pangkat, tentara.pangkat) &&
                Objects.equals(matra, tentara.matra) &&
                Objects.equals(id, tentara.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, pangkat, matra, id);
    }
}