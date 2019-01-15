package main.java.aplikasi.codeshare.robby.FinalProject.model;

public class TipeKomputer {
    private Long id_tipe;
    private String nama_tipe;

    public TipeKomputer(Long id_tipe, String nama_tipe) {
        this.id_tipe = id_tipe;
        this.nama_tipe = nama_tipe;
    }

    public  TipeKomputer(){}

    public Long getId_tipe() {
        return id_tipe;
    }

    public void setId_tipe(Long id_tipe) {
        this.id_tipe = id_tipe;
    }

    public String getNama_tipe() {
        return nama_tipe;
    }

    public void setNama_tipe(String nama_tipe) {
        this.nama_tipe = nama_tipe;
    }

    @Override
    public String toString() {
        return "TipeKomputer{" +
                "id_tipe=" + id_tipe +
                ", nama_tipe='" + nama_tipe + '\'' +
                '}';
    }
}
