package main.java.aplikasi.codeshare.riyan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionToBoothcamp {

    public static void main(String[] args) {
        Utils.migrate();
    }
}

class Utils{

    public static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";

    public static void migrate(){
        createTableBoothcamp();
        createTablePengajar();
        createTablePeserta();
        createTableJoinedIdRiyan();
        addConstraintForeignKey();
    }

    private static void createTableBoothcamp(){
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


    private static void createTablePengajar(){
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

    private static void createTablePeserta(){
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


    private static void createTableJoinedIdRiyan(){
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

    private static void addConstraintForeignKey(){
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



