package main.java.aplikasi.codeshare.robby.FinalProject.model;

public class Transaksi {
    Long idJoinedID;
    Komputer komputer;
    PemilikKomputer pemilikKomputer;
    TipeKomputer tipeKomputer;

    public Transaksi(Long idJoinedID, Komputer komputer, PemilikKomputer pemilikKomputer, TipeKomputer tipeKomputer) {
        this.idJoinedID = idJoinedID;
        this.komputer = komputer;
        this.pemilikKomputer = pemilikKomputer;
        this.tipeKomputer = tipeKomputer;
    }

    public Transaksi() {
    }

    public Long getIdJoinedID() {
        return idJoinedID;
    }

    public void setIdJoinedID(Long idJoinedID) {
        this.idJoinedID = idJoinedID;
    }

    public Komputer getKomputer() {
        return komputer;
    }

    public void setKomputer(Komputer komputer) {
        this.komputer = komputer;
    }

    public PemilikKomputer getPemilikKomputer() {
        return pemilikKomputer;
    }

    public void setPemilikKomputer(PemilikKomputer pemilikKomputer) {
        this.pemilikKomputer = pemilikKomputer;
    }

    public TipeKomputer getTipeKomputer() {
        return tipeKomputer;
    }

    public void setTipeKomputer(TipeKomputer tipeKomputer) {
        this.tipeKomputer = tipeKomputer;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "idJoinedID=" + idJoinedID +
                ", komputer=" + komputer +
                ", pemilikKomputer=" + pemilikKomputer +
                ", tipeKomputer=" + tipeKomputer +
                '}';
    }
}
