/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.migrate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class Migrate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        Utils.createTableSmartphone(conn, statement);
        Utils.createTableToko(conn, statement);
        Utils.createTableTokoHp(conn, statement);
        
    }
}

class Utils{
    public static final String DB_URL = "jdbc:mysql://localhost:3306/belajar_jdbc";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static void createTableSmartphone(Connection conn, Statement statement){
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "drop table if EXISTS smartphone;";
            statement = conn.createStatement();

            statement.execute(sql);

            sql =    "create table smartphone(" +
                "    id int(11) not null primary key auto_increment," +
                "    merk varchar(15) not null," +
                "    type varchar(15) not null," +
                "    ram int(2) not null," +
                "    camera int(2) not null" +
                "    );";

           statement.execute(sql);
            System.out.println("Create table smartphone success");
        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table Smartphone Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }
    public static void createTableToko(Connection conn, Statement statement){
        try{

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = conn.createStatement();

            String sql = "drop table if EXISTS toko;";
            statement.execute(sql);

            sql = "Create table toko("
                + "id int(11) not null primary key auto_increment,"
                + "name varchar(50) not null,"
                + "province varchar(25) not null,"
                + "phone char(15) not null"
                + ");";
           statement.execute(sql);


            System.out.println("create Table Toko Success");
        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table Toko Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }
    public static void createTableTokoHp(Connection conn, Statement statement){
        try{

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = conn.createStatement();

            String sql = "drop table if EXISTS toko_hp;";
            statement.execute(sql);

            sql = "Create table toko_hp("
                + "id int(11) not null primary key auto_increment,"
                + "toko_id int(11) not null,"
                + "smartphone_id int(11) not null"
                + ");";
           statement.execute(sql);
           System.out.println("create Table Toko HP Success");

// foreign key -> toko
            sql = "alter table toko_hp add foreign key (toko_id)"
                    + "references toko(id);";
            statement.execute(sql);
            System.out.println("create foreign key toko_id Success");

// foreign key -> smartphone
            sql = "alter table toko_hp add foreign key (smartphone_id)"
                    + "references smartphone(id);";
            statement.execute(sql);
            System.out.println("create foreign key smartphone_id Success");

        }catch (SQLException se) {
            System.out.println("Driver Get Connection Failed");
            System.out.println("Create Table toko_hp Failed");
            se.printStackTrace();
        }catch(Exception e){
            System.out.println("Test");
        }
    }

}
