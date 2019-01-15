package main.java.aplikasi.codeshare.puti.FinalProject;

import main.java.aplikasi.codeshare.puti.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Pembeli;
import main.java.aplikasi.codeshare.puti.FinalProject.service.PembeliService;

import java.sql.SQLException;

public class TestExist {
    public static void main(String[] args) throws SQLException {

        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());

        Pembeli juki = new Pembeli();
        juki.setIdPembeli(1L);
        juki.setNamaPembeli("Juki Sulaeman ");

        System.out.println(pembeliService.exists(juki.getIdPembeli()) ? "Juki Sulaeman ada di tabel pembeli " : "Juki Sulaeman tidak ada di tabel pembeli");




    }
}
