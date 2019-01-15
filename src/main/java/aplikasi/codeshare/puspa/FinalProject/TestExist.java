package main.java.aplikasi.codeshare.puspa.FinalProject;

import main.java.aplikasi.codeshare.puspa.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puspa.FinalProject.model.Water;
import main.java.aplikasi.codeshare.puspa.FinalProject.service.WaterService;

import java.sql.SQLException;

public class TestExist {

    public static void main(String[] args) throws SQLException {

        WaterService waterService = new WaterService(KoneksiDB.getKoneksi());

        Water milotic = new Water();
        milotic.setIdWater(7L);
        milotic.setNamaWater("Milotic");

        //ini get idnya bukan stringnya, makanya jadi ada karna baca id bukan baca string
        System.out.println(waterService.exists(milotic.getIdWater()) ? "Milotic ada di tabel water " : "Milotic tidak ada di tabel water");




    }
}
