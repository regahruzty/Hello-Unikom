package main.java.aplikasi.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionToJDBC {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER =
            "root";
    private static final String PASSWORD =
            "root";
//    private static final String DRIVER =
//            "com.mysql.cj.jdbc.Driverajsdfkljas;dlfj;";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        System.out.println("INI DB URL SAYA : "+DB_URL);
        System.out.println("INI USER DB SAYA : "+USER);
        System.out.println("INI PASS DB SAYA : "+PASSWORD);
//        System.out.println("INI DRIVER JDBC SAYA : "+DRIVER);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            statement = conn.createStatement();
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
