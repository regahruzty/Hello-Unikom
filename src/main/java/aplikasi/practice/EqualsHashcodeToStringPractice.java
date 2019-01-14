package main.java.aplikasi.practice;

import java.util.Objects;

public class EqualsHashcodeToStringPractice {

    public static void main(String[] args) {

        Reptil ular = new Reptil();
        Reptil salamander = new Reptil();

        Planet bumi = new Planet();
        bumi.setIdPlanet(1);
        bumi.setNamaPlanet("Bumi");
        bumi.setPenduduk(true);

        ular.setIdReptil(1);
        ular.setJumlahKakiReptil(4);
        ular.setKarnivor(true);
        ular.setWarnaReptil("HITAM");

        salamander.setIdReptil(1);
        salamander.setJumlahKakiReptil(4);
        salamander.setKarnivor(true);
        salamander.setWarnaReptil("HITAM");

        System.out.println("Hasil Object Equals Reptil : Ular vs Salamander -> "+(ular.equals(salamander) ? "Sama" : "Beda"));

        System.out.println("Hasil Object Equals Segala : Ular vs Bumi -> "+(ular.equals(bumi) ? "Sama" : "Beda"));

        System.out.println("Hasil Hashcode Reptil : Ular vs Salamander -> Ular = "+(ular.hashCode())+ " Salamander = "+(salamander.hashCode()));

        System.out.println("Hasil toString -> Ular = "+(ular.toString()));

        System.out.println("Hasil toString -> Salamander = "+(salamander.toString()));

    }
}

class Reptil{
    private Integer idReptil;
    private String warnaReptil;
    private Integer jumlahKakiReptil;
    private Boolean isKarnivor;

    public Reptil(Integer idReptil, String warnaReptil, Integer jumlahKakiReptil, Boolean isKarnivor) {
        this.idReptil = idReptil;
        this.warnaReptil = warnaReptil;
        this.jumlahKakiReptil = jumlahKakiReptil;
        this.isKarnivor = isKarnivor;
    }

    public Reptil() {
    }

    public Integer getIdReptil() {
        return idReptil;
    }

    public void setIdReptil(Integer idReptil) {
        this.idReptil = idReptil;
    }

    public String getWarnaReptil() {
        return warnaReptil;
    }

    public void setWarnaReptil(String warnaReptil) {
        this.warnaReptil = warnaReptil;
    }

    public Integer getJumlahKakiReptil() {
        return jumlahKakiReptil;
    }

    public void setJumlahKakiReptil(Integer jumlahKakiReptil) {
        this.jumlahKakiReptil = jumlahKakiReptil;
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
        Reptil reptil = (Reptil) o;
        return Objects.equals(idReptil, reptil.idReptil) && Objects.equals(warnaReptil, reptil.warnaReptil) && Objects.equals(jumlahKakiReptil, reptil.jumlahKakiReptil) && Objects.equals(isKarnivor, reptil.isKarnivor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idReptil, warnaReptil, jumlahKakiReptil, isKarnivor);
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "idReptil=" + idReptil +
                ", warnaReptil='" + warnaReptil + '\'' +
                ", jumlahKakiReptil=" + jumlahKakiReptil +
                ", isKarnivor=" + isKarnivor +
                '}';
    }
}

class Planet{
    private Integer idPlanet;
    private String namaPlanet;
    private Boolean isPenduduk;

    public Planet(Integer idPlanet, String namaPlanet, Boolean isPenduduk) {
        this.idPlanet = idPlanet;
        this.namaPlanet = namaPlanet;
        this.isPenduduk = isPenduduk;
    }

    public Planet() {
    }

    public Integer getIdPlanet() {
        return idPlanet;
    }

    public void setIdPlanet(Integer idPlanet) {
        this.idPlanet = idPlanet;
    }

    public String getNamaPlanet() {
        return namaPlanet;
    }

    public void setNamaPlanet(String namaPlanet) {
        this.namaPlanet = namaPlanet;
    }

    public Boolean getPenduduk() {
        return isPenduduk;
    }

    public void setPenduduk(Boolean penduduk) {
        isPenduduk = penduduk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(idPlanet, planet.idPlanet) &&
                Objects.equals(namaPlanet, planet.namaPlanet) &&
                Objects.equals(isPenduduk, planet.isPenduduk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlanet, namaPlanet, isPenduduk);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "idPlanet=" + idPlanet +
                ", namaPlanet='" + namaPlanet + '\'' +
                ", isPenduduk=" + isPenduduk +
                '}';
    }
}