package main.java.aplikasi.practice;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionToJDBC {

    public static void main(String[] args) {
        Utils.createTableSatu();
    }

}

class Utils{

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER =
            "root";
    private static final String PASSWORD =
            "";

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

}
