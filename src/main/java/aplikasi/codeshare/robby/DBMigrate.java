package main.java.aplikasi.codeshare.robby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMigrate {

    Connection conn = null;
    Statement statement = null;

    public static void main(String[] args) {
        Utils.migrate();
    }
}

class Utils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DRIVER_URL = "com.mysql.cj.jdbc.Driver";

    public static void migrate() {
        createTableKomputer();
        createTableTipeKomputer();
        createTablePemilikKomputer();
        createTableJoinedId();
        addConstraintForeignKey();
    }

    private static void createTableKomputer() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " create table komputer(" +
                    "id_komputer INT(11) not null auto_increment primary key," +
                    "merk varchar(255) not null," +
                    "tanggal_bangun date not null" +
                    ");";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE KOMPUTER SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE KOMPUTER FAILED");
            e.printStackTrace();
        }
    }

    private static void createTableTipeKomputer() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " create table tipe_komputer(" +
                    "id_tipe_komputer int(11) not null auto_increment primary key," +
                    "nama varchar(255) not null" +
                    ");";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE TIPE KOMPUTER SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE TIPE KOMPUTER FAILED");
            e.printStackTrace();
        }
    }

    private static void createTablePemilikKomputer() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " create table pemilik_komputer(" +
                    "id_pemilik_komputer INT(11) not null PRIMARY KEY auto_increment," +
                    "nama VARCHAR(255) not null" +
                    ");";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE PEMILIK KOMPUTER SUCCESS");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE PEMILIK KOMPUTER FAILED");
            e.printStackTrace();
        }
    }

    private static void createTableJoinedId() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " CREATE TABLE joined_id_robby ( " +
                    "   id_joined_id INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_komputer INT(11) not null , " +
                    "   id_tipe_komputer INT(11) not null , " +
                    "   id_pemilik_komputer INT(11) not null  " +
                    "   )";
            statement.executeUpdate(sql);
            System.out.println("CREATE TABLE JOIN_ID SUCCESS ");
        } catch (SQLException e) {
            System.out.println("CREATE TABLE JOIN_ID FAILED ");
            e.printStackTrace();
        }
    }

    private static void addConstraintForeignKey() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = conn.createStatement();
            String sql = " alter table joined_id_robby add constraint " +
                    " fk_table_komputer foreign key (id_komputer) references komputer(id_komputer) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_robby add constraint " +
                    " fk_table_pemilik_komputer foreign key (id_pemilik_komputer) references pemilik_komputer(id_pemilik_komputer) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id_robby add constraint " +
                    " fk_table_tipe_komputer foreign key (id_tipe_komputer) references tipe_komputer(id_tipe_komputer) ";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e) {
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();
        }
    }
}
