package main.java.aplikasi.codeshare.puspa.FinalProject;

import main.java.aplikasi.codeshare.puspa.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puspa.FinalProject.model.Fire;
import main.java.aplikasi.codeshare.puspa.FinalProject.model.Sinnoh;
import main.java.aplikasi.codeshare.puspa.FinalProject.model.Water;
import main.java.aplikasi.codeshare.puspa.FinalProject.service.FireService;
import main.java.aplikasi.codeshare.puspa.FinalProject.service.SinnohService;
import main.java.aplikasi.codeshare.puspa.FinalProject.service.WaterService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        SinnohService sinnohService = new SinnohService(KoneksiDB.getKoneksi());
        FireService fireService = new FireService(KoneksiDB.getKoneksi());
        WaterService waterService = new WaterService(KoneksiDB.getKoneksi());

        List<Fire> fires = new ArrayList<>();
        Fire fire = new Fire();

        fires = fireService.findAll();

        fire = fires.get(0);

        List<Water> waters = new ArrayList<>();
        Water water = new Water();

        waters = waterService.findAll();

        water = waters.get(0);

        sinnohService.deleteByIdFireAndIdWater(fire.getIdFire(), water.getIdWater());

        List<Sinnoh> sinnohs = sinnohService.findAll();

        System.out.println(sinnohs.toString());




    }
}
