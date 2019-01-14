package main.java.aplikasi.codeshare.ariya.jdbc_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.aplikasi.codeshare.ariya.jdbc_mvc.model.*;
public class TransactionToJDBC {

    public static final Transaksi transaksi =  new Transaksi();

    public static void main(String[] args) {
        Utils.migrate();

    }

}



class Utils{
    public static final Transaksi transaksi =  new Transaksi();
    public static final Motor motor =  new Motor();
    public static final Pembeli pembeli =  new Pembeli();


    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER =
            "root";
    private static final String PASSWORD =
            "";

    public static void migrate(){
        Utils.createTableMotor();
        Utils.insertDataMotor();
        Utils.createTablePembeli();
        Utils.insertDataPembeli();
        Utils.createTableTransaksi();
        Utils.addConstraintForeignKey();
        Utils.insertTableTransaksi();
    }


    //Method For Motor
    public static void createTableMotor(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE motor_ariya ( " +
                    "   id_motor INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_motor VARCHAR(255) not null, " +
                    "   merk_motor VARCHAR(255) not null, " +
                    "   harga_motor INT(15)not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void insertDataMotor(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void deleteDataMotor(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void updateDataMotor(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }

    //Method for Pembeli
    public static void createTablePembeli(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE pembeli ( " +
                    "   id_pembeli INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_pembeli VARCHAR(255) not null, " +
                    "   alamat_pembeli VARCHAR(255) not null, " +
                    "   pekerjaan VARCHAR(255) not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void insertDataPembeli(){

        List <Pembeli> pembeliList = new ArrayList<>();

        pembeli.setNama_pembeli("Ariya Agustian");
        pembeli.setAlamat("Jl Babakan Tarogong");
        pembeli.setPekerjaan("Wiraswasta");
        pembeliList.add(pembeli);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into pembeli (nama_pembeli, alamat_pembeli, pekerjaan) VALUES " +
                    "('"+pembeli.getNama_pembeli()+"', " +
                    "'"+pembeli.getAlamat()+"', " +
                    "'"+pembeli.getPekerjaan()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void deleteDataPembeli(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void updateDataPembeli(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }


    //Method for Transaksi
    public static void createTableTransaksi(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE transaksi ( " +
                    "   id_transaksi INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_pembeli int(11) not null, " +
                    "   id_motor int(11) not null, " +
                    "   tanggal_pembelian DATE not null, " +
                    "   jumlah_pembelian INT(15)not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void insertTableTransaksi(){

        List <Transaksi> transaksiList = new ArrayList<>();

        pembeli.setId_pembeli(1);
        motor.setId_motor(1);
        transaksi.setId_pembeli(pembeli);
        transaksi.setId_motor(motor);
        transaksi.setTanggal_pembelian("2019-01-22");
        transaksi.setJumlah_pembelian(5);
        transaksiList.add(transaksi);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into transaksi (id_pembeli, id_motor, tanggal_pembelian, jumlah_pembelian) VALUES " +
                    "('"+transaksi.getId_pembeli().getId_pembeli()+"', " +
                    "'"+transaksi.getId_motor().getId_motor()+"', " +
                    "'"+transaksi.getTanggal_pembelian()+"', " +
                    "'"+transaksi.getJumlah_pembelian()+"')";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void deleteDataTransaksi(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }
    public static void updateDataTransaksi(){

        List <Motor> motorList = new ArrayList<>();

        motor.setNama_motor("Mio Fino");
        motor.setMerk_motor("Yamaha");
        motor.setHarga(18000000);
        motorList.add(motor);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " insert into motor_ariya (nama_motor, merk_motor, harga_motor) VALUES " +
                    "('"+motor.getNama_motor()+"', " +
                    "'"+motor.getMerk_motor()+"', " +
                    "'"+motor.getHarga()+"' )";

            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }

    //Relasi
    public static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " alter table transaksi add constraint " +
                    " fk_transaksi_motor_ariya foreign key (id_motor) references motor_ariya (id_motor) ";
            statement.executeUpdate(sql);
            sql = " alter table Transaksi add constraint " +
                    " fk_transaksi_pembeli foreign key (id_pembeli) references Pembeli (id_pembeli) ";
            statement.executeUpdate(sql);
            System.out.println("INI CONNECTION SAYA : "+conn);
            System.out.println("CREATE TABLE SUCCESS ");
        } catch (SQLException e){
            System.out.println("GET CONNECTION FAILED");
            System.out.println("CREATE TABLE FAILED ");
            e.printStackTrace();
        }
    }



}