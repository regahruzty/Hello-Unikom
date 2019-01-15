package main.java.aplikasi.codeshare.herdi.migration;

import main.java.aplikasi.codeshare.herdi.config.KoneksiDB;
import main.java.aplikasi.codeshare.herdi.service.JoinedHerdiService;

import java.sql.SQLException;

public class Migration {
    public static void main(String[] args) throws SQLException {
        JoinedHerdiService joinedHerdiService = new JoinedHerdiService(KoneksiDB.getKoneksi());
        joinedHerdiService.migrate();
    }
}
