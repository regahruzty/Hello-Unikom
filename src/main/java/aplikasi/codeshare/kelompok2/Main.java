/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.kelompok2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author NGHTMRE
 */
public class Main{


    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kelompok2";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    static final Scanner input = new Scanner(System.in);


    public static void main(String[] args) {


        System.out.println("Pilih Menu : ");
        System.out.println("1 : Tambah Narasi");
        System.out.println("2 : Tampil Narasi");

        int pilih = input.nextInt();

        if (pilih == 1) {
            tambahNarasi();
        } else if (pilih == 2){
            tampilNarasi();
        } else{
            System.out.println("Tidak Ada yang dipilih");
        }


    }


    public static void tambahNarasi(){
        Connection conn = null;
        Statement stmt = null;
        List<Narasi> narasiList = new ArrayList<>();
        Narasi narasi = new Narasi();
        Motor motor = new Motor();
        Mobil mobil = new Mobil();
        Komputer komputer = new Komputer();
        Boothcamp boothcamp = new Boothcamp();
        System.out.print("Masukkan ID Motor: ");
        motor.setId_motor(input.nextInt());
        System.out.print("Masukkan ID Mobil: ");
        mobil.setId_mobil(input.nextInt());
        System.out.print("Masukkan ID Komputer: ");
        komputer.setId_komputer(input.nextInt());
        System.out.print("Masukkan ID Boothcamp: ");
        boothcamp.setId_boothcamp(input.nextInt());

        narasi.setId_motor(motor);
        narasi.setId_boothcamp(boothcamp);
        narasi.setId_komputer(komputer);
        narasi.setId_mobil(mobil);
        narasiList.add(narasi);

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "insert into narasi (id_boothcamp, id_motor, id_komputer, id_mobil) "
                    + "values (?, ?, ?, ?) ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, narasi.getId_motor().getId_motor());
            ps.setInt(2, narasi.getId_boothcamp().getId_boothcamp());
            ps.setInt(3, narasi.getId_mobil().getId_mobil());
            ps.setInt(4, narasi.getId_komputer().getId_komputer());

            ps.execute();
            conn.close();

        } catch (Exception e) {
            System.out.println("error handling");
        }

    }


    // Fungsi Tampil Narasi
    public static void tampilNarasi(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "select * "
                    + "from narasi "
                    + "join motor on narasi.id_motor = motor.id_motor "
                    + "join mobil on narasi.id_mobil = mobil.id_mobil "
                    + "join komputer on narasi.id_komputer = komputer.id_komputer "
                    + "join boothcamp on narasi.id_boothcamp = boothcamp.id_boothcamp; ";
            ResultSet rs = stmt.executeQuery(sql);
            List<Narasi> narasiList = new ArrayList<>();

            while(rs.next()){
                //Retrieve by column name
                Narasi narasi = new Narasi();
                Motor motor = new Motor();
                Mobil mobil = new Mobil();
                Komputer komputer = new Komputer();
                Boothcamp boothcamp = new Boothcamp();
                narasi.setId_narasi(rs.getInt("id_narasi"));
                motor.setMerk_motor(rs.getString("merk_motor"));
                motor.setNama_motor(rs.getString("nama_motor"));
                mobil.setMerk_mobil(rs.getString("merk_mobil"));
                mobil.setNama_mobil(rs.getString("nama_mobil"));
                komputer.setMerk_komputer(rs.getString("merk_komputer"));
                komputer.setNama_tipe(rs.getString("nama_komputer"));
                boothcamp.setNama_boothcamp(rs.getString("nama_boothcamp"));
                boothcamp.setLokasi(rs.getString("lokasi"));
                narasi.setId_motor(motor);
                narasi.setId_boothcamp(boothcamp);
                narasi.setId_komputer(komputer);
                narasi.setId_mobil(mobil);
                narasiList.add(narasi);
            }

            //Display values
            for (Narasi narasi : narasiList) {

                System.out.println("======================================");

                System.out.println("Pada Boothcamp "+narasi.getId_narasi()+" - "+narasi.getId_boothcamp().getNama_boothcamp()+
                        " Terdapat barang - barang berupa Motor dengan Merk "+
                        narasi.getId_motor().getMerk_motor()+
                        ", Komputer dengan Merk "+
                        narasi.getId_komputer().getMerk_komputer()+
                        ", dan Mobil dengan Merk "+
                        narasi.getId_mobil().getMerk_mobil()+
                        ". Dimana Detail Motor, Mobil, dan Komputer tersebut Adalah "+
                        narasi.getId_motor().getNama_motor()+", "+
                        narasi.getId_mobil().getNama_mobil()+", "+
                        narasi.getId_komputer().getNama_tipe()
                );

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}


class Narasi{
    Motor id_motor;
    Mobil id_mobil;
    Komputer id_komputer;
    Boothcamp id_boothcamp;
    int id_narasi;

    public Narasi(Motor id_motor, Mobil id_mobil, Komputer id_komputer, Boothcamp id_boothcamp, int id_narasi) {
        this.id_motor = id_motor;
        this.id_mobil = id_mobil;
        this.id_komputer = id_komputer;
        this.id_boothcamp = id_boothcamp;
        this.id_narasi = id_narasi;
    }

    Narasi() {

    }

    public Motor getId_motor() {
        return id_motor;
    }

    public void setId_motor(Motor id_motor) {
        this.id_motor = id_motor;
    }

    public Mobil getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(Mobil id_mobil) {
        this.id_mobil = id_mobil;
    }

    public Komputer getId_komputer() {
        return id_komputer;
    }

    public void setId_komputer(Komputer id_komputer) {
        this.id_komputer = id_komputer;
    }

    public Boothcamp getId_boothcamp() {
        return id_boothcamp;
    }

    public void setId_boothcamp(Boothcamp id_boothcamp) {
        this.id_boothcamp = id_boothcamp;
    }

    public int getId_narasi() {
        return id_narasi;
    }

    public void setId_narasi(int id_narasi) {
        this.id_narasi = id_narasi;
    }



}


// Object Motor
class Motor {

    int id_motor;
    String merk_motor, nama_motor;

    public Motor(int id_motor, String merk_motor, String nama_motor) {
        this.id_motor = id_motor;
        this.merk_motor = merk_motor;
        this.nama_motor = nama_motor;
    }

    Motor() {

    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public String getMerk_motor() {
        return merk_motor;
    }

    public void setMerk_motor(String merk_motor) {
        this.merk_motor = merk_motor;
    }

    public String getNama_motor() {
        return nama_motor;
    }

    public void setNama_motor(String nama_motor) {
        this.nama_motor = nama_motor;
    }



}


// Object Komputer
class Komputer {
    int id_komputer;
    String merk_komputer, nama_tipe;
    public Komputer(int id_komputer, String merk_komputer, String nama_tipe) {
        this.id_komputer = id_komputer;
        this.merk_komputer = merk_komputer;
        this.nama_tipe = nama_tipe;
    }
    public Komputer(){}
    public int getId_komputer() {
        return id_komputer;
    }
    public void setId_komputer(int id_komputer) {
        this.id_komputer = id_komputer;
    }
    public String getMerk_komputer() {
        return merk_komputer;
    }
    public void setMerk_komputer(String merk_komputer) {
        this.merk_komputer = merk_komputer;
    }
    public String getNama_tipe() {
        return nama_tipe;
    }
    public void setNama_tipe(String nama_tipe) {
        this.nama_tipe = nama_tipe;
    }
}

// Object Boothcamp
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


// Object Mobil
class Mobil {
    int id_mobil;
    String merk_mobil, nama_mobil;

    public Mobil(int id_mobil, String merk_mobil, String nama_mobil) {
        this.id_mobil = id_mobil;
        this.merk_mobil = merk_mobil;
        this.nama_mobil = nama_mobil;
    }

    public Mobil(){
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(int id_mobil) {
        this.id_mobil = id_mobil;
    }

    public String getMerk_mobil() {
        return merk_mobil;
    }

    public void setMerk_mobil(String merk_mobil) {
        this.merk_mobil = merk_mobil;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

}
