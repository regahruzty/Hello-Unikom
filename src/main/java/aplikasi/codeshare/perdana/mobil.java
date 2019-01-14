package main.java.aplikasi.codeshare.perdana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Main {
    //    JDBC driver name and database URL
    static final String JDBC_DRIVER =
            "com.mysql.cj.jdbc.Driver";
    static final String DB_URL =
            "jdbc:mysql://localhost/mobil_perdana";

    //    Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sqlmobil;

            // AMBIL DATA MOBIL
            sqlmobil = "select * from mobil";
            ResultSet rsmobil = stmt.executeQuery(sqlmobil);
            if (rsmobil.next()) {
                Mobil mobil = new Mobil();
                mobil.setNama(rsmobil.getString("nama"));
                mobil.setJenis(rsmobil.getString("jenis"));
                mobil.setJumlahBan(rsmobil.getInt("jumlahban"));
                System.out.print(" Mobil " + mobil.getNama());
                System.out.print(" Merupakan Jenis Mobil " + mobil.getJenis());
                System.out.print(" Memiliki Jumlah Ban " + mobil.getJumlahBan());
            }

            System.out.println(" Penanda no eror");
        } catch (Exception e) {
            System.out.println("Mobil Masuk Jurang");
            e.printStackTrace();
        }
    }
        public static class Mobil {
            //Inisialisasi Variabel
            private String nama;
            private String jenis;
            private Integer jumlahBan;

            //Inisialisasi Constructor Mobil
            public Mobil(String nama, String jenis, Integer jumlahBan) {
                this.nama = nama;
                this.jenis = jenis;
                this.jumlahBan = jumlahBan;
            }

            public Mobil() {

            }

            public String getNama() {
                return nama;
            }

            public void setNama(String nama) {
                this.nama = nama;
            }

            public String getJenis() {
                return jenis;
            }

            public void setJenis(String jenis) {
                this.jenis = jenis;
            }

            public Integer getJumlahBan() {
                return jumlahBan;
            }

            public void setJumlahBan(Integer jumlahBan) {
                this.jumlahBan = jumlahBan;
            }
        }
        
    }
