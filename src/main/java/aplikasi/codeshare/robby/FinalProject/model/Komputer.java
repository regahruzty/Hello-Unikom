package main.java.aplikasi.codeshare.robby.FinalProject.model;

import java.sql.Date;
import java.util.Objects;

public class Komputer {

    //variabel komputer
    private Long id_komputer;
    private String merk;
    private Date tanggalBangun;


    //konstruktor dengan args


    public Komputer(Long id_komputer, String merk, Date tanggalBangun) {
        this.id_komputer = id_komputer;
        this.merk = merk;
        this.tanggalBangun = tanggalBangun;
    }

    //komstruktor kosong
    public Komputer() {
    }

    //getter dan setter

    public Long getId_komputer() {
        return id_komputer;
    }

    public void setId_komputer(Long id_komputer) {
        this.id_komputer = id_komputer;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Date getTanggalBangun() {
        return tanggalBangun;
    }

    public void setTanggalBangun(Date tanggalBangun) {
        this.tanggalBangun = tanggalBangun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Komputer komputer = (Komputer) o;
        return id_komputer == komputer.id_komputer &&
                Objects.equals(merk, komputer.merk) &&
                Objects.equals(tanggalBangun, komputer.tanggalBangun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_komputer, merk, tanggalBangun);
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "id_komputer=" + id_komputer +
                ", merk='" + merk + '\'' +
                ", tanggalBangun=" + tanggalBangun +
                '}';
    }
}
