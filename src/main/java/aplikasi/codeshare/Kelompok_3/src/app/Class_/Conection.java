/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.Kelompok_3.src.app.Class_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Centry
 */
public class Conection {
      Connection conn = null;
 
  public static Connection connectDB(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kelompok3","root", "root");
             
                return conn;
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null,"Tidak Ada Koneksi Ke DataBase","Failed",JOptionPane.WARNING_MESSAGE);
                //System.out.println("Database not found");
                //System.out.println(e);
                return null;
            }
  }
}
