package main.java.aplikasi.codeshare.perdana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Migrate {

    public static void main(String[] args) {
        main.java.aplikasi.codeshare.perdana.Utils.migrate();
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
        createTableSatu();
        createTableDua();
        createTableTiga();
        createTableJoinedId();
        addConstraintForeignKey();
    }

    private static void createTableSatu(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE produk ( " +
                    "   id_produk INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama VARCHAR(255) not null, " +
                    "   merk VARCHAR(255) not null, " +
                    "   waktu_pembuatan DATE not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE SATU SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE SATU FAILED ");
            e.printStackTrace();
        }
    }

    private static void createTableDua(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE jenis ( " +
                    "   id_jenis INT(11) not null PRIMARY KEY auto_increment, " +
                    "   jenis VARCHAR(255) not null, " +
                    "   keterangan VARCHAR(255) not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE DUA SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE DUA FAILED ");
            e.printStackTrace();
        }
    }

    private static void createTableTiga(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE kondisi ( " +
                    "   id_kondisi INT(11) not null PRIMARY KEY auto_increment, " +
                    "   body VARCHAR(255) not null, " +
                    "   mesin VARCHAR(255) not null, " +
                    "   create_date DATE not null " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TIGA SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE TIGA FAILED ");
            e.printStackTrace();
        }
    }

    private static void createTableJoinedId(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE joined_id_perdana ( " +
                    "   id_joined_id INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_produk INT(11) not null , " +
                    "   id_jenis INT(11) not null , " +
                    "   id_kondisi INT(11) not null  " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE JOIN_ID SUCCESS ");
        } catch (SQLException e){
            System.out.println("CREATE TABLE JOIN_ID FAILED ");
            e.printStackTrace();
        }
    }

    private static void addConstraintForeignKey(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = " alter table joined_id_perdana add constraint " +
                    " fk_table_produk foreign key (id_produk) references produk (id_produk) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_perdana add constraint " +
                    " fk_table_jenis foreign key (id_jenis) references jenis (id_jenis) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_perdana add constraint " +
                    " fk_table_kondisi foreign key (id_kondisi) references kondisi (id_kondisi) ";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e){
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();
        }
    }

}
