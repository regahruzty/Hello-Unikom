import Config.ConnectionDB;
import Model.*;
import Service.*;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            Obat obat = new Obat();
            obat.setNama_obat("Panadol");

            Dosis dosis = new Dosis();
            dosis.setDosis("3 x 1");

            Jenis jenis = new Jenis();
            jenis.setJenis_obat("Keras");

            ObatService obatService = new ObatService(ConnectionDB.getKoneksi());
            obat = obatService.save(obat);

            DosisService dosisService = new DosisService(ConnectionDB.getKoneksi());
            dosis = dosisService.save(dosis);

            JenisService jenisService = new JenisService(ConnectionDB.getKoneksi());
            jenis = jenisService.save(jenis);

            ObatRelation obatRelation = new ObatRelation();
            obatRelation.setId_obat(obat);
            obatRelation.setId_dosis(dosis);
            obatRelation.setId_jenis(jenis);

            ObatRelationService obatRelationService = new ObatRelationService(ConnectionDB.getKoneksi());
            obatRelation = obatRelationService.save(obatRelation);

            System.out.println("obatRelation : "+obatRelation.toString());

        }catch (SQLException e){
            System.out.println("Error Code "+ e.getErrorCode());

            JOptionPane.showMessageDialog(null,"Error "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }


    }
}
