package main.java.aplikasi.codeshare.robby.FinalProject.model;

public class PemilikKomputer {

    private Long id_pemilik_komputer;
    private String nama_pemilik_komputer;

    public PemilikKomputer(Long id_pemilik_komputer, String nama_pemilik_komputer) {
        this.id_pemilik_komputer = id_pemilik_komputer;
        this.nama_pemilik_komputer = nama_pemilik_komputer;
    }

    public PemilikKomputer() {
    }

    public Long getId_pemilik_komputer() {
        return id_pemilik_komputer;
    }

    public void setId_pemilik_komputer(Long id_pemilik_komputer) {
        this.id_pemilik_komputer = id_pemilik_komputer;
    }

    public String getNama_pemilik_komputer() {
        return nama_pemilik_komputer;
    }

    public void setNama_pemilik_komputer(String nama_pemilik_komputer) {
        this.nama_pemilik_komputer = nama_pemilik_komputer;
    }

    @Override
    public String toString() {
        return "PemilikKomputer{" +
                "id_pemilik_komputer=" + id_pemilik_komputer +
                ", nama_pemilik_komputer='" + nama_pemilik_komputer + '\'' +
                '}';
    }
}
