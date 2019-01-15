package main.java.aplikasi.codeshare.herdi;

import main.java.aplikasi.codeshare.herdi.config.KoneksiDB;
import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.service.BurungService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {

        BurungService burungService = new BurungService(KoneksiDB.getKoneksi());

        Burung merpati = new Burung();
        merpati.setId_burung(2);
        merpati.setNama("Merpati");
        merpati.setWarna("Putih");
        merpati.setParuh("Kecil, Runcing");

        burungService.update(merpati);

        Burung cenderawasih = new Burung();

        cenderawasih.setId_burung(3);
        cenderawasih.setNama("Cenderawasih");
        cenderawasih.setWarna("Putih hitam");
        cenderawasih.setParuh("Kecil");

        burungService.update(cenderawasih);

        List<Burung> burungList = burungService.findAll();

        for(Burung burung1 : burungList){
            System.out.println(burungList.toString());
        }

    }
}
