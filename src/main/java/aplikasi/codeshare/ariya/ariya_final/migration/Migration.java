package main.java.aplikasi.codeshare.ariya.ariya_final.migration;

import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.TransaksiService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        transaksiService.migrate();

    }

}
