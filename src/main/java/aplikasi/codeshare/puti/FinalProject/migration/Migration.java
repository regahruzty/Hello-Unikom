package main.java.aplikasi.codeshare.puti.FinalProject.migration;

import config.KoneksiDB;
import service.FakturService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        FakturService fakturService = new FakturService(KoneksiDB.getKoneksi());
        fakturService.migrate();

    }

}