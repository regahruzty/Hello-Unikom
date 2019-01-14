package main.java.aplikasi.practice;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionToJDBC {

    public static void main(String[] args) {
     //Utils.createTableSatu();
     Utils.createTableKaryawan();
    }

    static class Utils {

            private static final String DB_URL =
                    "jdbc:mysql://localhost:3306/belajar_jdbc";
            private static final String USER =
                    "root";
            private static final String PASSWORD =
                    "root";


            public static void createTableSatu() {
                try {
                   Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
                   Statement statement = conn.createStatement();
                    String sql = " CREATE TABLE table_satu ( " +
                            "   id_table_satu INT(11) not null PRIMARY KEY auto_increment, " +
                            "   description VARCHAR(255) not null, " +
                            "   create_user VARCHAR(255) not null, " +
                            "   create_date DATE not null " +
                            "   )";
                    statement.executeUpdate(sql);
                    System.out.println("INI CONNECTION SAYA : " + conn);
                    System.out.println("CREATE TABLE SUCCESS ");
                } catch (SQLException e) {
                    System.out.println("GET CONNECTION FAILED");
                    System.out.println("CREATE TABLE FAILED ");
                    e.printStackTrace();
                }
            }

            public static void createTableKaryawan(){

                try {

                    Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                    Statement state = conn.createStatement();
                    String CREATE = "CREATE TABLE KARYAWAN(" +
                            "id_karyawan INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                            "nama_karyawan VARCHAR(50) NOT NULL, " +
                            "alamat_karyawan VARCHAR(255) NOT NULL, " +
                            "telp_karyawan VARCHAR(14) NOT NULL " +
                            ")";

                    state.executeUpdate(CREATE);
                    System.out.println("Ini Connection : " + conn);
                    System.out.println("Create table success");

                }catch (SQLException ex){
                    Logger.getLogger(TransactionToJDBC.class.getName()).log(Level.SEVERE,null,ex);
                }catch (Exception e){
                    System.out.println("Failed create table ");
                    e.printStackTrace();
                }
            }

        }
    }

