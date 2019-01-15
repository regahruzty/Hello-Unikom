package main.java.aplikasi.codeshare.fajar.Final_Project.src.Migration;
import main.java.aplikasi.codeshare.fajar.Final_Project.src.Config.ConnectionDB;
import java.sql.SQLException;

import main.java.aplikasi.codeshare.fajar.Final_Project.src.Service.ObatRelationService;

import javax.swing.*;

public class Migration {
    public static void main(String[] args) throws SQLException{
        ObatRelationService obatRelationService = new ObatRelationService(ConnectionDB.getKoneksi());
        try {
            obatRelationService.migrate();
            JOptionPane.showMessageDialog(null,"Migrasi Data Berhasi","Succees!",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
