package main.java.aplikasi.codeshare.herdi.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionToBurung {

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
        createTableBurung();
        createTableRajawali();
        addConstraintForeignKey();
    }

    private static void createTableBurung(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement state = conn.createStatement();

            String CREATE = " CREATE TABLE Burung ( " +
                    "   id_burung INT(11) not null PRIMARY KEY auto_increment, " +
                    "   description VARCHAR(255) not null, " +
                    "   id_rajawali INT(11) not null " +
                    "   )";

            state.executeUpdate(CREATE);
            System.out.println("Create table burung success");
        }catch (SQLException ex){
            Logger.getLogger(TransactionToBurung.class.getName()).log(Level.SEVERE,null,ex);

        }catch (Exception e){
            System.out.println("Create table burung failed");
            e.printStackTrace();
        }
    }

    private static void createTableRajawali(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement state = conn.createStatement();
            String CREATE = " CREATE TABLE Rajawali ( " +
                    "   id_rajawali INT(11) not null PRIMARY KEY auto_increment, " +
                    "   nama_rajawali VARCHAR(50) not null, " +
                    "   warna_rajawali VARCHAR(50) not null, " +
                    "   paruh_rajawali VARCHAR(50) not null, " +
                    "   tgl_rajawali DATE not null " +
                    "   )";
            state.executeUpdate(CREATE);
            System.out.println("Create table rajawali success");
        }catch (SQLException ex){
            Logger.getLogger(TransactionToBurung.class.getName()).log(Level.SEVERE,null,ex);
        }catch (Exception e){
            System.out.println("Create table rajawali failed");
            e.printStackTrace();
        }
    }

    private static void addConstraintForeignKey(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement state = conn.createStatement();

            String ADD = "ALTER TABLE burung ADD CONSTRAINT " +
                    "fk_rajawali FOREIGN KEY (id_rajawali) REFERENCES rajawali (id_rajawali) ";

            state.executeUpdate(ADD);

            System.out.println("Add constraint success");
        }catch (SQLException ex){
            Logger.getLogger(TransactionToBurung.class.getName()).log(Level.SEVERE,null,ex);
        }catch (Exception e){
            System.out.println("Add constraint failed");
            e.printStackTrace();

        }
    }


}
