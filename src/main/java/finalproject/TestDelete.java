package main.java.finalproject;

import main.java.finalproject.config.KoneksiDB;
import main.java.finalproject.model.Ekosistem;
import main.java.finalproject.model.Hewan;
import main.java.finalproject.model.Tumbuhan;
import main.java.finalproject.service.EkosistemService;
import main.java.finalproject.service.HewanService;
import main.java.finalproject.service.TumbuhanService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        EkosistemService ekosistemService = new EkosistemService(KoneksiDB.getKoneksi());
        HewanService hewanService = new HewanService(KoneksiDB.getKoneksi());
        TumbuhanService tumbuhanService = new TumbuhanService(KoneksiDB.getKoneksi());

        List<Hewan> hewans = new ArrayList<>();
        Hewan hewan = new Hewan();

        hewans = hewanService.findAll();

        hewan = hewans.get(0);

        List<Tumbuhan> tumbuhans = new ArrayList<>();
        Tumbuhan tumbuhan = new Tumbuhan();

        tumbuhans = tumbuhanService.findAll();

        tumbuhan = tumbuhans.get(0);

        ekosistemService.deleteByIdHewanAndIdTumbuhan(hewan.getIdHewan(), tumbuhan.getIdTumbuhan());

        List<Ekosistem> ekosistems = ekosistemService.findAll();

        System.out.println(ekosistems.toString());




    }
}
