package main.java.aplikasi.codeshare.riyan.migration;

import main.java.aplikasi.codeshare.riyan.config.KoneksiDB;
import main.java.aplikasi.codeshare.riyan.service.JoinedIDRiyanService;

import java.sql.SQLException;

public class Migration {
    public static void main(String[] args) throws SQLException {
        JoinedIDRiyanService joinedIDRiyanService = new JoinedIDRiyanService(KoneksiDB.getKoneksi());
        joinedIDRiyanService.migrate();
    }
}
