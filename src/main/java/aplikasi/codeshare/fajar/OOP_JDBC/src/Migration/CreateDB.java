package Migration;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) {

        Connection Conn = null;
        Statement st;
        try {
            String username = "root";
            String password = "";
            Conn = DriverManager.getConnection("jdbc:mysql://localhost/?user="+username+" & password= "+password);
            st=Conn.createStatement();
            int Result = st.executeUpdate("CREATE DATABASE obat");
            JOptionPane.showMessageDialog(null,"Database Berhasil Dibuat ","Error",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error "+e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }



    }







}
