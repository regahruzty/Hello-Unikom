import Config.ConnectionDB;
import Model.*;
import Service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class testUpdate {

    public static void main(String[] args) throws SQLException {
        try{
            JenisService jenisService = new JenisService(ConnectionDB.getKoneksi());

            Jenis obatKeras = new Jenis();
            obatKeras.setId_jenis(1);
            obatKeras.setJenis_obat("Obat Keras");

            jenisService.update(obatKeras);

            Jenis obatBiasa = new Jenis();
            obatBiasa.setId_jenis(1);
            obatBiasa.setJenis_obat("Obat Biasa");

            jenisService.update(obatBiasa);

            List<Jenis> jeniss = jenisService.findAll();

            for(Jenis jenis : jeniss){
                System.out.println(jeniss.toString());
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }




    }
}
