package main.java.aplikasi.codeshare.puspa.FinalProject;

import config.KoneksiDB;
import model.Fire;
import model.Sinnoh;
import model.Water;
import service.FireService;
import service.SinnohService;
import service.WaterService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Fire fire = new Fire();
        fire.setNamaFire("Infernape");

        Water water = new Water();
        water.setNamaWater("Golduck");

        FireService fireService = new FireService(KoneksiDB.getKoneksi());
        fire = fireService.save(fire);

        WaterService waterService = new WaterService(KoneksiDB.getKoneksi());
        water = waterService.save(water);

        Sinnoh sinnoh = new Sinnoh();
        sinnoh.setFire(fire);
        sinnoh.setWater(water);

        SinnohService sinnohService = new SinnohService(KoneksiDB.getKoneksi());
        sinnoh = sinnohService.save(sinnoh);

        System.out.println("SINNOH : "+sinnoh.toString());

    }
}
