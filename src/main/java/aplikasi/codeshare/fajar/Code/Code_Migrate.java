/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fajar.Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Centry
 */

//Transaksi to JDBC

public class Code_Migrate {
    
    
    
    //public static final String DRIVER =  "com.mysql.jdbc.Driver";
    public static void main(String[] args) {
        Utils.CreateTableSatu();
        Utils.CreateTableData();
        Utils.CreateTableDetail();
        Utils.CreateTableRelation();
        
    }
}

class Utils{
      public static final String DB_URL =  "jdbc:mysql://localhost:3306/belajar_jdbc";
      public static final String USER =  "root";
      public static final String PASSWORD =  "";
      
      public static void CreateTableSatu(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS table_satu;";
            st.executeUpdate(cl);
            
            String sql = ""
                    + " CREATE TABLE table_satu("
                    + "id_table_satu INT(11) not null PRIMARY KEY auto_increment,"
                    + "create_user VARCHAR(255) NOT NULL,"
                    + "create_date VARCHAR(255) NOT NULL);";
            st.executeUpdate(sql);
            System.out.println("ini Connection TAbel satu "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to table 1");
        }
      }
      public static void CreateTableData(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS table_data;";
            st.executeUpdate(cl);
            
            String sql = ""
                    + " CREATE TABLE table_data("
                    + "id_data INT(11) not null PRIMARY KEY auto_increment,"
                    + "user_nama VARCHAR(255) NOT NULL,"
                    + "user_tgl_daftar date NOT NULL,"
                    + "user_alamat VARCHAR(255) NOT NULL,"
                    + "user_email VARCHAR(50)NOT NULL);";
            st.executeUpdate(sql);
            System.out.println("ini Connection Data "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to Data");
        }
        }
      public static void CreateTableDetail(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS table_Detail;";
            st.executeUpdate(cl);
            
            String sql = ""
                    + " CREATE TABLE table_detail("
                    + "id_detail INT(11) not null PRIMARY KEY auto_increment,"
                    + "detail_riwayat_hidup VARCHAR(255) NOT NULL,"
                    + "detail_pangkat date NOT NULL,"
                    + "detail_history_jabatan VARCHAR(255) NOT NULL,"
                    + "Detail_jabatan_Sekarang VARCHAR(50) NOT NULL);";
            st.executeUpdate(sql);
            System.out.println("ini Connection Detail "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to Detail");
        }
        }
      
      public static void CreateTableRelation(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS table_relation;";
            st.executeUpdate(cl);
            
            String sql = ""
                    + " CREATE TABLE table_relation("
                    + "id_relasi INT(11) not null PRIMARY KEY auto_increment,"
                    + "id_detail INT(11) not null,"
                    + "id_data INT(11) not null,"
                    + "id_table_satu INT(11) not null"
                    + ");";
            st.executeUpdate(sql);
            System.out.println("ini Connection saya "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed Relation");
        }
        }
      public static void CreateContraintForeighnKey(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            String sql;
            //Clear table if exists
            
            sql = "alter table table_relation "
                    + "add contraint fk_table_satu foreign key (id_table_satu) references table_satu(id_table_satu);";
            st.executeUpdate(sql);
            sql = "alter table table_relation "
                    + "add contraint fk_table_data foreign key (id_data) references table_data(id_data);";
            st.executeUpdate(sql);
            sql = "alter table table_relation "
                    + "add contraint fk_table_detail foreign key (id_detail) references table_detail(id_detail);";
            st.executeUpdate(sql);
            System.out.println("ini Connection Contraint Foreighn Key "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to Foreign Key");
        }
        }
    }

