package main.java.aplikasi.codeshare.ariya.ariya_final;

import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.PembeliService;

import java.sql.SQLException;

public class TestExist {

    public static void main(String[] args) throws SQLException {

        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());

        Pembeli ariya = new Pembeli();
        ariya.setId_pembeli(1L);
        ariya.setNama_pembeli("Ariya Agustian");

        System.out.println(pembeliService.exists(ariya.getId_pembeli()) ? "Ariya ada di tabel pembeli " : "Ariya tidak ada di tabel pembeli");




    }
}

