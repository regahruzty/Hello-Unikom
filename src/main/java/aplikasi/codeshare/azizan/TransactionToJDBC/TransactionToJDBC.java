package main.java.aplikasi.codeshare.azizan.TransactionToJDBC;

import java.sql.*;

public class TransactionToJDBC {
    private static final String DB_URL =
            "jdbc:mysql://localhost/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";
    // public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        System.out.println("INI DB URL SAYA: " + DB_URL);
        System.out.println("INI USER DB SAYA: " + USER);
        System.out.println("INI PASS DB SAYA: " + PASS);
        // System.out.println("INI DRIVER JDBC SAYA: " + DRIVER);

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = conn.createStatement();
            String sql = "CREATE TABLE table_satu(" +
                    "id_table_satu INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                    "description VARCHAR(255) NOT NULL," +
                    "create_user VARCHAR(255) NOT NULL," +
                    "create_date  DATE NOT NULL" +
                    ")";

            statement.executeUpdate(sql);

            System.out.println("INI DB URL SAYA: " + conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
