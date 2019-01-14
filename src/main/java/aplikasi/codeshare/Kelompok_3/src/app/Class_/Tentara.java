/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.Kelompok_3.src.app.Class_;

import java.util.Objects;

/**
 *
 * @author Centry
 */
public class Tentara {
    private String nama;
    private String pangkat;
    private String matra;

    private Tentara(String nama, String pangkat, String matra) {
        this.nama = nama;
        this.pangkat = pangkat;
        this.matra = matra;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tentara tentara = (Tentara) o;
        return Objects.equals(nama, tentara.nama) &&
                Objects.equals(pangkat, tentara.pangkat) &&
                Objects.equals(matra, tentara.matra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, pangkat, matra);
    }

}
