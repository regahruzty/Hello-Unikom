/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class TransactionToJDBC {
    
    public static void main(String[]args){
        
            Connection conn = null;
            Statement statement = null;
            Utils.createTableMahasiswa();
        
    }
}

class Utils{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/belajar_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD="";
    
//    private static final String DRIVER="com.mysql.jdbc.Driver";
    
    public static void createTableMahasiswa(){
        try { 
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            Statement statement = conn.createStatement();
            String sql="CREATE TABLE mahasiswa ("+
                    "nim INT(11) not null PRIMARY KEY auto_increment," +
                    "nama_mhs VARCHAR(255) not null," +
                    "jurusan VARCHAR(255) not null,"+
                    "gender VARCHAR(255) not null,"+
                    "tgl_masuk DATE not null"+
                    ")";
            statement.executeUpdate(sql);
            System.out.println("Sukses"+conn);
        } catch (SQLException ex) {
            System.out.println("GAGAL KONEKSI");
            Logger.getLogger(TransactionToJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
