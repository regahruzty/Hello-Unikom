package main.java.aplikasi.codeshare.ariya.jdbc_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TransactionToJDBC {

    public static void main(String[] args) {
        Utils.migrate();

    }

}



class Utils{

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER =
            "root";
    private static final String PASSWORD =
            "";

    public static void migrate(){
        Utils.createTableMotor();
        Utils.createTablePembeli();
        Utils.createTableTransaksi();
        Utils.addConstraintForeignKey();
    }

    public static void createTableSatu(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE table_satu ( " +
                    "   id_table_satu INT(11) not null PRIMARY KEY auto_increment, " +
                    "   description VARCHAR(255) not null, " +
                    "   create_user VARCHAR(255) not null, " +
                    "   create_date DATE not null " +
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

    public static void createTablePembeli(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE pembeli ( " +
                    "   id_pembeli INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_pembeli VARCHAR(255) not null, " +
                    "   alamat_pembeli VARCHAR(255) not null, " +
                    "   no_telepon INT(15)not null " +
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