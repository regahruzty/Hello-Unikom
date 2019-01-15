package main.java.aplikasi.codeshare.azizan.TNI.Model;

import java.util.Objects;

public class TNI {
    private Long idTNI;
    private Tentara tentara;
    private TentaraAktif tentaraAktif;
    private Batalyon batalyon;

    public TNI(Long idTNI, Tentara tentara, TentaraAktif tentaraAktif, Batalyon batalyon) {
        this.idTNI = idTNI;
        this.tentara = tentara;
        this.tentaraAktif = tentaraAktif;
        this.batalyon = batalyon;
    }

    public TNI(){

    }

    public Long getIdTNI() {
        return idTNI;
    }

    public void setIdTNI(Long idTNI) {
        this.idTNI = idTNI;
    }

    public Tentara getTentara() {
        return tentara;
    }

    public void setTentara(Tentara tentara) {
        this.tentara = tentara;
    }

    public TentaraAktif getTentaraAktif() {
        return tentaraAktif;
    }

    public void setTentaraAktif(TentaraAktif tentaraAktif) {
        this.tentaraAktif = tentaraAktif;
    }

    public Batalyon getBatalyon() {
        return batalyon;
    }

    public void setBatalyon(Batalyon batalyon) {
        this.batalyon = batalyon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TNI tni = (TNI) o;
        return Objects.equals(idTNI, tni.idTNI) &&
                Objects.equals(tentara, tni.tentara) &&
                Objects.equals(tentaraAktif, tni.tentaraAktif) &&
                Objects.equals(batalyon, tni.batalyon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTNI, tentara, tentaraAktif, batalyon);
    }

    @Override
    public String toString() {
        return "TNI{" +
                "idTNI=" + idTNI +
                ", tentara=" + tentara +
                ", tentaraAktif=" + tentaraAktif +
                ", batalyon=" + batalyon +
                '}';
    }
}
