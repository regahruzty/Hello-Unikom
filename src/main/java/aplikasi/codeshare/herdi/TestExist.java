package main.java.aplikasi.codeshare.herdi;

import main.java.aplikasi.codeshare.herdi.config.KoneksiDB;
import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.service.BurungService;

import java.sql.SQLException;

public class TestExist {
    public static void main(String[] args) throws SQLException {
        BurungService burungService = new BurungService(KoneksiDB.getKoneksi());

        Burung burung = new Burung();
        burung.setId_burung(1);
        burung.setNama("Elang");
        burung.setWarna("Coklat");
        burung.setParuh("Kuat, Tajam");

        System.out.println(burungService.exists((long) burung.getId_burung()) ? "Elang ada di tabel burung " : "Elang tidak ada di tabel burung");
    }
}
