package main.java.aplikasi.codeshare.puspa.FinalProject.migration;

import config.KoneksiDB;
import service.SinnohService;

import java.sql.SQLException;

public class Migration {
    public static void main(String[] args) throws SQLException {

        SinnohService sinnohService = new SinnohService(KoneksiDB.getKoneksi());
        sinnohService.migrate();

    }
}
