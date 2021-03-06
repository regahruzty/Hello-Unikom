package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Testing;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TentaraService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        TentaraService tentaraService = new TentaraService(KoneksiDB.getKoneksi());

        Tentara tono = new Tentara();
        tono.setIdTentara(2L);
        tono.setNamaTentara("Budi");

        tentaraService.update(tono);

        Tentara joni = new Tentara();
        joni.setIdTentara(6L);
        joni.setNamaTentara("Steward");

        tentaraService.update(joni);

        List<Tentara> tentaras = tentaraService.findAll();

        for (Tentara tentara : tentaras){
            System.out.println(tentaras.toString());
        }

    }

}
