package main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Migration;
import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Config.ConnectionDB;
import java.sql.SQLException;

import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Service.ObatRelationService;
import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Service.ObatService;

import javax.swing.*;

public class Migration_Clear {
    public static void main(String[] args) throws SQLException{
        ObatRelationService obatRelationService = new ObatRelationService(ConnectionDB.getKoneksi());
        try {
            int i = JOptionPane.showConfirmDialog (null, "Hapus Semua Tabel","Peringatan",0,JOptionPane.WARNING_MESSAGE);
            if(i == 0){
                obatRelationService.ClearingTable();
                JOptionPane.showMessageDialog(null,"Semua Table Berhasil Di Hapus","Succees!",JOptionPane.INFORMATION_MESSAGE);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}