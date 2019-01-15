package main.java.aplikasi.codeshare.puti.FinalProject.migration;

import main.java.aplikasi.codeshare.puti.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puti.FinalProject.service.FakturService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        FakturService fakturService = new FakturService(KoneksiDB.getKoneksi());
        fakturService.migrate();

    }

}