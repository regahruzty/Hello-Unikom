package main.java.finalproject;

import main.java.finalproject.config.KoneksiDB;
import main.java.finalproject.model.Hewan;
import main.java.finalproject.service.HewanService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        HewanService hewanService = new HewanService(KoneksiDB.getKoneksi());

        Hewan gajah = new Hewan();
        gajah.setIdHewan(2L);
        gajah.setNamaHewan("Gajah");

        hewanService.update(gajah);

        Hewan jerapah = new Hewan();
        jerapah.setIdHewan(3L);
        jerapah.setNamaHewan("Jerapah");

        hewanService.update(jerapah);

        List<Hewan> hewans = hewanService.findAll();

        for(Hewan hewan : hewans){
            System.out.println(hewans.toString());
        }



    }
}
