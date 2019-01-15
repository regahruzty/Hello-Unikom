package main.java.aplikasi.codeshare.fajar.Final_Project.src;
import main.java.aplikasi.codeshare.fajar.Final_Project.src.Config.ConnectionDB;
import main.java.aplikasi.codeshare.fajar.Final_Project.src.Model.*;
import main.java.aplikasi.codeshare.fajar.Final_Project.src.Service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class testDelete {
    public static void main(String[] args) throws SQLException {

        try{
            ObatRelationService obatRelationService = new ObatRelationService(ConnectionDB.getKoneksi());
            ObatService obatService = new ObatService(ConnectionDB.getKoneksi());
            DosisService dosisService = new DosisService(ConnectionDB.getKoneksi());
            JenisService jenisService = new JenisService(ConnectionDB.getKoneksi());

            List<Obat> obats = new ArrayList<>();
            Obat obat = new Obat();
            obats = obatService.findAll();
            obat = obats.get(0);

            List<Dosis> dosiss = new ArrayList<>();
            Dosis dosis = new Dosis();
            dosiss = dosisService.findAll();
            dosis = dosiss.get(0);

            List<Jenis> jeniss = new ArrayList<>();
            Jenis jenis = new Jenis();
            dosiss = dosisService.findAll();
            dosis = dosiss.get(0);

            obatRelationService.deleteByIdObatIdDosisIdJenis(obat.getId_obat(), dosis.getId_dosis(),jenis.getId_jenis());

            List<ObatRelation> obatRelation = obatRelationService.findAll();

            System.out.println(obatRelationService.toString());
        }catch (SQLException e){
            System.out.println("Error Code SQL "+ e.getErrorCode());
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception ex){
            System.out.println("Error Code Data "+ ex.getCause());
        }





    }
}
