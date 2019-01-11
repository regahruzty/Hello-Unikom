package main.java.aplikasi.codeshare.azizan.Model;

public class Obat {
    private int id;
    private String nama_obat;
    private String dosis_obat;
    private String keterangan_obat;

    public Obat(int id, String nama_obat, String dosis_obat, String keterangan_obat) {
        this.id = id;
        this.nama_obat = nama_obat;
        this.dosis_obat = dosis_obat;
        this.keterangan_obat = keterangan_obat;
    }

    public Obat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public String getDosis_obat() {
        return dosis_obat;
    }

    public void setDosis_obat(String dosis_obat) {
        this.dosis_obat = dosis_obat;
    }

    public String getKeterangan_obat() {
        return keterangan_obat;
    }

    public void setKeterangan_obat(String keterangan_obat) {
        this.keterangan_obat = keterangan_obat;
    }

}