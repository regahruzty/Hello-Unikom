package main.java.aplikasi.codeshare.riyan;

public class Main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_boothcamp";

    // Database credentials
    static final String USER = "root";
    static final String PASS ="";


    public static void main(String[] args){

    }
}
//coba

class Boothcamp {
    // Inisialisasi atribut
    int id_boothcamp;
    String nama_boothcamp;
    String lokasi;
    // Hasil dari constructor
    public Boothcamp(int id_boothcamp, String nama_boothcamp, String lokasi) {
        this.id_boothcamp = id_boothcamp;
        this.nama_boothcamp = nama_boothcamp;
        this.lokasi = lokasi;
    }

    Boothcamp() {

    }
    //Ini getter id_boothcamp
    public int getId_boothcamp() {
        return id_boothcamp;
    }
    //Ini setter id_boothcamp
    public void setId_boothcamp(int id_boothcamp) {
        this.id_boothcamp = id_boothcamp;
    }
    //Ini getter nama_boothcamp
    public String getNama_boothcamp() {
        return nama_boothcamp;
    }
    //Ini setter nama_boothcamp
    public void setNama_boothcamp(String nama_boothcamp) {
        this.nama_boothcamp = nama_boothcamp;
    }
    //Ini getter lokasi
    public String getLokasi() {
        return lokasi;
    }
    //Ini setter lokasi
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}

