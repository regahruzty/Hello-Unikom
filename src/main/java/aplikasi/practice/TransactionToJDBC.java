package main.java.aplikasi.practice;

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
            "root";

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
            String sql = " CREATE TABLE table_satu ( " +
                    "   id_table_satu INT(11) not null PRIMARY KEY auto_increment, " +
                    "   description VARCHAR(255) not null, " +
                    "   create_user VARCHAR(255) not null, " +
                    "   create_date DATE not null " +
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
            String sql = " CREATE TABLE table_dua ( " +
                    "   id_table_dua INT(11) not null PRIMARY KEY auto_increment, " +
                    "   description VARCHAR(255) not null, " +
                    "   create_user VARCHAR(255) not null, " +
                    "   create_date DATE not null " +
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
            String sql = " CREATE TABLE table_tiga ( " +
                    "   id_table_tiga INT(11) not null PRIMARY KEY auto_increment, " +
                    "   description VARCHAR(255) not null, " +
                    "   create_user VARCHAR(255) not null, " +
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
            String sql = " CREATE TABLE joined_id ( " +
                    "   id_joined_id INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_table_satu INT(11) not null , " +
                    "   id_table_dua INT(11) not null , " +
                    "   id_table_tiga INT(11) not null  " +
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
            String sql = " alter table joined_id add constraint " +
                    " fk_table_satu foreign key (id_table_satu) references table_satu (id_table_satu) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id add constraint " +
                    " fk_table_dua foreign key (id_table_dua) references table_dua (id_table_dua) ";
            statement.executeUpdate(sql);
            sql = " alter table joined_id add constraint " +
                    " fk_table_tiga foreign key (id_table_tiga) references table_tiga (id_table_tiga) ";
            statement.executeUpdate(sql);
            System.out.println("ADD FOREIGN KEY CONSTRAINT SUCCESS ");
        } catch (SQLException e){
            System.out.println("ADD FOREIGN KEY CONSTRAINT FAILED ");
            e.printStackTrace();
        }
    }

}
