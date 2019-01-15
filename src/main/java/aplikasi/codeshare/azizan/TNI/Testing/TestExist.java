package main.java.aplikasi.codeshare.azizan.TNI.Testing;

import main.java.aplikasi.codeshare.azizan.TNI.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TentaraService;

import java.sql.SQLException;

public class TestExist {

    public static void main(String[] args) throws SQLException {
        TentaraService tentaraService = new TentaraService(KoneksiDB.getKoneksi());

        Tentara tentara = new Tentara();
        tentara.setIdTentara(1L);
        tentara.setNamaTentara("Joni");

        System.out.println(tentaraService.exists(tentara.getIdTentara()) ?
                ""+tentara.getNamaTentara()+" ada di label tentara" : ""+tentara.getNamaTentara()+" tidak ada di label tentara");
    }

}
