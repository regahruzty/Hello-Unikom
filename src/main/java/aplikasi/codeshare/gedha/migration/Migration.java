package main.java.aplikasi.codeshare.gedha.migration;

import main.java.aplikasi.codeshare.gedha.config.KoneksiDB;
import main.java.aplikasi.codeshare.gedha.model.Koleksi;
import main.java.aplikasi.codeshare.gedha.service.KoleksiService;

import java.sql.SQLException;

public class Migration {
    public static void main(String[] args) throws SQLException {
        KoleksiService koleksiService = new KoleksiService(KoneksiDB.getKoneksi());
        koleksiService.migrate();
    }
}
