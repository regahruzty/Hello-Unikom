package main.java.aplikasi.codeshare.riyan.belajar_jdbc;

import main.java.aplikasi.codeshare.riyan.belajar_jdbc.model.Boothcamp;
import main.java.aplikasi.codeshare.riyan.belajar_jdbc.model.Pengajar;
import main.java.aplikasi.codeshare.riyan.belajar_jdbc.model.Peserta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionToBoothcamp {

    public static void main(String[] args) {
        Utils.migrate();
    }
}

class Utils{
    //membuat object
    public static final Boothcamp boothcamp = new Boothcamp();
    public static final Pengajar pengajar = new Pengajar();
    public static final Peserta peserta = new Peserta();

    public static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";

    public static void migrate(){
        //Memanggil semua method boothcamp
        createTableBoothcamp();
        insertDataBoothcamp();
        //Memanggil semua method pengajar
        createTablePengajar();
        insertDataPengajar();
        //Memanggil semua method peserta
        createTablePeserta();
        insertDataPeserta();

        createTableJoinedIdRiyan();
        addConstraintForeignKey();
    }

    //Method untuk boothcamp
    public static void createTableBoothcamp(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE boothcamp ( " +
                    "   id_boothcamp INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_boothcamp VARCHAR(255) not null, " +
                    "   lokasi VARCHAR(255) not null, " +
                    "   alamat VARCHAR(255) not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE Boothcamp SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE Boothcamp GAGAL");
            e.printStackTrace();
        }
    }
    public static void insertDataBoothcamp(){
        List <Boothcamp> boothcampList = new ArrayList<>();

        boothcamp.setId_boothcamp(1);
        boothcamp.setNama_boothcamp("Indonesia Android Kejar");
        boothcamp.setLokasi("UNIKOM");
        boothcamp.setAlamat("Dipatiukur no 112-114");
        boothcampList.add(boothcamp);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " insert into boothcamp (id_boothcamp, nama_boothcamp, lokasi, alamat) VALUES " +
                    "('"+boothcamp.getId_boothcamp()+"', " +
                    "'"+boothcamp.getNama_boothcamp()+"', " +
                    "'"+boothcamp.getLokasi()+"', " +
                    "'"+boothcamp.getAlamat()+"' )";

            statement.executeUpdate(sql);
            System.out.println("Insert Data Boothcamp Sukses");
        }catch (SQLException e){
            System.out.println("Insert Data Boothcamp Gagal");
            e.printStackTrace();
        }
    }

    //Method untuk pengajar
    public static void createTablePengajar(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE pengajar ( " +
                    "   id_pengajar INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_pengajar VARCHAR(255) not null, " +
                    "   no_telp VARCHAR(255) not null, " +
                    "   spesialis VARCHAR(255) not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE Pengajar SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE Pengajar GAGAL");
            e.printStackTrace();
        }
    }
    public static void insertDataPengajar(){
        List <Pengajar> pengajarList = new ArrayList<>();

        pengajar.setId_pengajar(1);
        pengajar.setNama_pengajar("Anne");
        pengajar.setNo_telp("08522133698");
        pengajar.setSpesialis("Java");
        pengajarList.add(pengajar);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " insert into pengajar (id_pengajar, nama_pengajar, no_telp, spesialis) VALUES " +
                    "('"+pengajar.getId_pengajar()+"', " +
                    "'"+pengajar.getNama_pengajar()+"', " +
                    "'"+pengajar.getNo_telp()+"', " +
                    "'"+pengajar.getSpesialis()+"' )";

            statement.executeUpdate(sql);
            System.out.println("Insert Data Pengajar Sukses");
        }catch (SQLException e){
            System.out.println("Insert Data Pengajar Gagal");
            e.printStackTrace();
        }
    }

    //Method untuk peserta
    public static void createTablePeserta(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE peserta ( " +
                    "   id_peserta INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_peserta VARCHAR(255) not null, " +
                    "   no_telp VARCHAR(255) not null, " +
                    "   alamat VARCHAR(255) not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE Peserta SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE Peserta GAGAL");
            e.printStackTrace();
        }
    }
    public static void insertDataPeserta(){
        List <Peserta> pesertaList = new ArrayList<>();

        peserta.setId_peserta(1);
        peserta.setNama_peserta("Riyan Nur Rizal");
        peserta.setNo_telp("085723624509");
        peserta.setAlamat("Kubang Selatan N0 1");
        pesertaList.add(peserta);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " insert into peserta (id_peserta, nama_peserta, no_telp, alamat) VALUES " +
                    "('"+peserta.getId_peserta()+"', " +
                    "'"+peserta.getNama_peserta()+"', " +
                    "'"+peserta.getNo_telp()+"', " +
                    "'"+peserta.getAlamat()+"' )";

            statement.executeUpdate(sql);
            System.out.println("Insert Data Peserta Sukses");
        }catch (SQLException e){
            System.out.println("Insert Data Peserta Gagal");
            e.printStackTrace();
        }
    }

    public static void createTableJoinedIdRiyan(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE joined_id_riyan ( " +
                    "   id_joined_id_riyan INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_boothcamp INT(11) not null , " +
                    "   id_pengajar INT(11) not null , " +
                    "   id_peserta INT(11) not null  " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE Joined Id Riyan SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE Joined Id Riyan GAGAL");
            e.printStackTrace();
        }
    }

    public static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " alter table joined_id_riyan add constraint " +
                    " fk_boothcamp foreign key (id_boothcamp) references boothcamp (id_boothcamp) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_riyan add constraint " +
                    " fk_pengajar foreign key (id_pengajar) references pengajar (id_pengajar) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_riyan add constraint " +
                    " fk_peserta foreign key (id_peserta) references peserta (id_peserta) ";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e){
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();
        }
    }
}



