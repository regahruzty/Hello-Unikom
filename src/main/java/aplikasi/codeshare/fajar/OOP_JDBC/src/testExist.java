package main.java.aplikasi.codeshare.fajar.OOP_JDBC.src;
import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Config.ConnectionDB;
import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Model.*;
import main.java.aplikasi.codeshare.fajar.OOP_JDBC.src.Service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class testExist {

    public static void main(String[] args) throws SQLException {
        try{
            ObatService tumbuhanService = new ObatService(ConnectionDB.getKoneksi());

            Obat cari = new Obat();
            cari.setId_obat(1);
            cari.setNama_obat("Panadol");
            String tmp= cari.getNama_obat();
            System.out.println(tumbuhanService.exists(cari.getId_obat()) ? tmp+" ada di tabel obat " : tmp+" tidak ada di tabel tumbuhan");


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }



    }
}