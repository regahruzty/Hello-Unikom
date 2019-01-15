package main.java.aplikasi.codeshare.azizan.TNI.Model;

import java.util.Objects;

public class TentaraAktif {
    private Long idTentaraAktif;
    private String statusTentara;

    public TentaraAktif(Long idTentaraAktif, String statusTentara) {
        this.idTentaraAktif = idTentaraAktif;
        this.statusTentara = statusTentara;
    }

    public TentaraAktif(){

    }

    public Long getIdTentaraAktif() {
        return idTentaraAktif;
    }

    public void setIdTentaraAktif(Long idTentaraAktif) {
        this.idTentaraAktif = idTentaraAktif;
    }

    public String getStatusTentara() {
        return statusTentara;
    }

    public void setStatusTentara(String statusTentara) {
        this.statusTentara = statusTentara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TentaraAktif that = (TentaraAktif) o;
        return Objects.equals(idTentaraAktif, that.idTentaraAktif) &&
                Objects.equals(statusTentara, that.statusTentara);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTentaraAktif, statusTentara);
    }

    @Override
    public String toString() {
        return "TentaraAktif{" +
                "idTentaraAktif=" + idTentaraAktif +
                ", statusTentara='" + statusTentara + '\'' +
                '}';
    }
}
