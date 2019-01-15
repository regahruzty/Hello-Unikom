package main.java.aplikasi.codeshare.fajar.Final_Project.src.Config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import javax.swing.*;

public class ConnectionDB {

    public static DataSource getKoneksi(){
        BasicDataSource basicDataSource = new BasicDataSource();
        try{

            basicDataSource.setUrl("jdbc:mysql://localhost:3306/Obat");
            basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            basicDataSource.setUsername("root");
            basicDataSource.setPassword("");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage() +"tidak ada koneksi ke database","Error",JOptionPane.WARNING_MESSAGE);
        }
        return basicDataSource;
    }

}