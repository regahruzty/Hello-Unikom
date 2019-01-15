package main.java.aplikasi.codeshare.azizan.TNI.Testing;

import main.java.aplikasi.codeshare.azizan.TNI.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TentaraService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        TentaraService tentaraService = new TentaraService(KoneksiDB.getKoneksi());

        Tentara tono = new Tentara();
        tono.setIdTentara(2L);
        tono.setNamaTentara("Tono");

        tentaraService.update(tono);

        Tentara joni = new Tentara();
        joni.setIdTentara(1L);
        joni.setNamaTentara("Joni");

        tentaraService.update(joni);

        List<Tentara> tentaras = tentaraService.findAll();

        for (Tentara tentara : tentaras){
            System.out.println(tentaras.toString());
        }

    }

}
