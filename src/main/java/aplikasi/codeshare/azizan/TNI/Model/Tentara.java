package main.java.aplikasi.codeshare.azizan.TNI.Model;

import java.util.Date;
import java.util.Objects;

public class Tentara {
    private Long idTentara;
    private String namaTentara;
    private String pangkat;
    private String matra;
    private boolean isPerwira;

    public Tentara(Long idTentara, String namaTentara, String pangkat, String matra, boolean isPerwira) {
        this.idTentara = idTentara;
        this.namaTentara = namaTentara;
        this.pangkat = pangkat;
        this.matra = matra;
        this.isPerwira = isPerwira;
    }
    public Tentara(){

    }

    public Long getIdTentara() {
        return idTentara;
    }

    public void setIdTentara(Long idTentara) {
        this.idTentara = idTentara;
    }

    public String getNamaTentara() {
        return namaTentara;
    }

    public void setNamaTentara(String namaTentara) {
        this.namaTentara = namaTentara;
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

    public boolean isPerwira() {
        return isPerwira;
    }

    public void setPerwira(boolean perwira) {
        isPerwira = perwira;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tentara tentara = (Tentara) o;
        return isPerwira == tentara.isPerwira &&
                Objects.equals(idTentara, tentara.idTentara) &&
                Objects.equals(namaTentara, tentara.namaTentara) &&
                Objects.equals(pangkat, tentara.pangkat) &&
                Objects.equals(matra, tentara.matra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTentara, namaTentara, pangkat, matra, isPerwira);
    }

    @Override
    public String toString() {
        return "Tentara{" +
                "idTentara=" + idTentara +
                ", namaTentara='" + namaTentara + '\'' +
                ", pangkat='" + pangkat + '\'' +
                ", matra='" + matra + '\'' +
                ", isPerwira=" + isPerwira +
                '}';
    }
}

