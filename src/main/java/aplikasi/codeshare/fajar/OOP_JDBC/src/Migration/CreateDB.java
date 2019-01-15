package main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Migration;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) throws ClassNotFoundException {

        Connection Conn = null;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String password = "root";
            Conn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+username+" & password= "+password);
            st=Conn.createStatement();
            int Result = st.executeUpdate("CREATE DATABASE obat");
            JOptionPane.showMessageDialog(null,"Database Berhasil Dibuat ","Error",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error SQL"+e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }



    }







}
