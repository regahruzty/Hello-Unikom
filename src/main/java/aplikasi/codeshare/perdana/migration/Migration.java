package main.java.aplikasi.codeshare.perdana.migration;

import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.service.Joined_IDService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        Joined_IDService ekosistemService = new Joined_IDService(KoneksiDB.getKoneksi());
        ekosistemService.migrate();
    }

}
