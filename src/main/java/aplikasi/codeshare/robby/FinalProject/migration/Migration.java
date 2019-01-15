package main.java.aplikasi.codeshare.robby.FinalProject.migration;

import main.java.aplikasi.codeshare.robby.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.robby.FinalProject.service.TransaksiService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        transaksiService.migrate();
    }

}
