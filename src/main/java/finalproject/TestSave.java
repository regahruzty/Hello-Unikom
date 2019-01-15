package main.java.finalproject;

import main.java.finalproject.config.KoneksiDB;
import main.java.finalproject.model.Ekosistem;
import main.java.finalproject.model.Hewan;
import main.java.finalproject.model.Tumbuhan;
import main.java.finalproject.service.EkosistemService;
import main.java.finalproject.service.HewanService;
import main.java.finalproject.service.TumbuhanService;

import java.sql.SQLException;

public class TestSave {

    public static void main(String[] args) throws SQLException {

        Hewan hewan = new Hewan();
        hewan.setNamaHewan("Singa");

        Tumbuhan tumbuhan = new Tumbuhan();
        tumbuhan.setNamaTumbuhan("Gedang");

        HewanService hewanService = new HewanService(KoneksiDB.getKoneksi());
        hewan = hewanService.save(hewan);

        TumbuhanService tumbuhanService = new TumbuhanService(KoneksiDB.getKoneksi());
        tumbuhan = tumbuhanService.save(tumbuhan);

        Ekosistem ekosistem = new Ekosistem();
        ekosistem.setHewan(hewan);
        ekosistem.setTumbuhan(tumbuhan);

        EkosistemService ekosistemService = new EkosistemService(KoneksiDB.getKoneksi());
        ekosistem = ekosistemService.save(ekosistem);

        System.out.println("EKOSISTEM : "+ekosistem.toString());

    }
}
