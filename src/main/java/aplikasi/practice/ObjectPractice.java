package main.java.aplikasi.practice;

import main.java.aplikasi.model.Kucing;

import java.util.ArrayList;
import java.util.Objects;

public class ObjectPractice {

    public static void main(String[] args) {

        IkanHiu ikanHiu = new IkanHiu();

        ikanHiu.setIdHiu(1);

        SifatIkan sifatIkanHiu = new SifatIkan();

        SifatInsang sifatInsangHiu = new SifatInsang();
        sifatInsangHiu.setLebar(true);
        sifatInsangHiu.setTajam(false);
        sifatInsangHiu.setTinggi(true);

        sifatIkanHiu.setBerinsang(sifatInsangHiu);
        sifatIkanHiu.setBerparuparu(false);
        sifatIkanHiu.setBersisik(false);
        sifatIkanHiu.setKarnivor(true);

        ikanHiu.setSifatIkan(sifatIkanHiu);

        System.out.println("Ini Ikan Hiu dengan ID "+ikanHiu.getIdHiu()+" lalu Sifat Ikan Ini : ");
        System.out.println("Insang Lebar : "+(ikanHiu.getSifatIkan().getBerinsang().getLebar() ? "Iya" :"Tidak"));
        System.out.println("Insang Tinggi : "+(ikanHiu.getSifatIkan().getBerinsang().getTinggi() ? "Iya" :"Tidak"));
        System.out.println("Insang Tajam : "+(ikanHiu.getSifatIkan().getBerinsang().getTajam() ? "Iya" :"Tidak"));
        System.out.println("Berparuparu : "+(ikanHiu.getSifatIkan().getBerparuparu() ? "Iya" :"Tidak"));
        System.out.println("Bersisik : "+(ikanHiu.getSifatIkan().getBersisik() ? "Iya" :"Tidak"));
        System.out.println("Karnivor : "+(ikanHiu.getSifatIkan().getKarnivor() ? "Iya" :"Tidak"));

    }
}

class SifatInsang {
    private Boolean isLebar;
    private Boolean isTajam;
    private Boolean isTinggi;

    public SifatInsang(Boolean isLebar, Boolean isTajam, Boolean isTinggi) {
        this.isLebar = isLebar;
        this.isTajam = isTajam;
        this.isTinggi = isTinggi;
    }

    public SifatInsang() {
    }

    public Boolean getLebar() {
        return isLebar;
    }

    public void setLebar(Boolean lebar) {
        isLebar = lebar;
    }

    public Boolean getTajam() {
        return isTajam;
    }

    public void setTajam(Boolean tajam) {
        isTajam = tajam;
    }

    public Boolean getTinggi() {
        return isTinggi;
    }

    public void setTinggi(Boolean tinggi) {
        isTinggi = tinggi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SifatInsang that = (SifatInsang) o;
        return Objects.equals(isLebar, that.isLebar) &&
                Objects.equals(isTajam, that.isTajam) &&
                Objects.equals(isTinggi, that.isTinggi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLebar, isTajam, isTinggi);
    }

    @Override
    public String toString() {
        return "SifatInsang{" +
                "isLebar=" + isLebar +
                ", isTajam=" + isTajam +
                ", isTinggi=" + isTinggi +
                '}';
    }
}

class SifatIkan {
    private Boolean isBersisik;
    private Boolean isBerparuparu;
    private SifatInsang isBerinsang;
    private Boolean isKarnivor;

    public SifatIkan(Boolean isBersisik, Boolean isBerparuparu, SifatInsang isBerinsang, Boolean isKarnivor) {
        this.isBersisik = isBersisik;
        this.isBerparuparu = isBerparuparu;
        this.isBerinsang = isBerinsang;
        this.isKarnivor = isKarnivor;
    }

    public SifatIkan() {
    }

    public Boolean getBersisik() {
        return isBersisik;
    }

    public void setBersisik(Boolean bersisik) {
        isBersisik = bersisik;
    }

    public Boolean getBerparuparu() {
        return isBerparuparu;
    }

    public void setBerparuparu(Boolean berparuparu) {
        isBerparuparu = berparuparu;
    }

    public SifatInsang getBerinsang() {
        return isBerinsang;
    }

    public void setBerinsang(SifatInsang berinsang) {
        isBerinsang = berinsang;
    }

    public Boolean getKarnivor() {
        return isKarnivor;
    }

    public void setKarnivor(Boolean karnivor) {
        isKarnivor = karnivor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SifatIkan ikan = (SifatIkan) o;
        return Objects.equals(isBersisik, ikan.isBersisik) &&
                Objects.equals(isBerparuparu, ikan.isBerparuparu) &&
                Objects.equals(isBerinsang, ikan.isBerinsang) &&
                Objects.equals(isKarnivor, ikan.isKarnivor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBersisik, isBerparuparu, isBerinsang, isKarnivor);
    }

    @Override
    public String toString() {
        return "SifatIkan{" +
                "isBersisik=" + isBersisik +
                ", isBerparuparu=" + isBerparuparu +
                ", isBerinsang=" + isBerinsang +
                ", isKarnivor=" + isKarnivor +
                '}';
    }
}

class IkanHiu{
    private Integer idHiu;
    private SifatIkan sifatIkan;

    public IkanHiu(Integer idHiu, SifatIkan sifatIkan) {
        this.idHiu = idHiu;
        this.sifatIkan = sifatIkan;
    }

    public IkanHiu() {
    }

    public Integer getIdHiu() {
        return idHiu;
    }

    public void setIdHiu(Integer idHiu) {
        this.idHiu = idHiu;
    }

    public SifatIkan getSifatIkan() {
        return sifatIkan;
    }

    public void setSifatIkan(SifatIkan sifatIkan) {
        this.sifatIkan = sifatIkan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IkanHiu ikanHiu = (IkanHiu) o;
        return Objects.equals(idHiu, ikanHiu.idHiu) &&
                Objects.equals(sifatIkan, ikanHiu.sifatIkan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHiu, sifatIkan);
    }

    @Override
    public String toString() {
        return "IkanHiu{" +
                "idHiu=" + idHiu +
                ", sifatIkan=" + sifatIkan +
                '}';
    }
}