package main.java.finalproject;

import main.java.finalproject.config.KoneksiDB;
import main.java.finalproject.model.Tumbuhan;
import main.java.finalproject.service.TumbuhanService;

import java.sql.SQLException;

public class TestExist {

    public static void main(String[] args) throws SQLException {

        TumbuhanService tumbuhanService = new TumbuhanService(KoneksiDB.getKoneksi());

        Tumbuhan kaktus = new Tumbuhan();
        kaktus.setIdTumbuhan(3L);
        kaktus.setNamaTumbuhan("Kaktus");

        System.out.println(tumbuhanService.exists(kaktus.getIdTumbuhan()) ? "Kaktus ada di tabel tumbuhan " : "Kaktus tidak ada di tabel tumbuhan");

    }
}
