package main.java.finalproject.migration;

import main.java.finalproject.config.KoneksiDB;
import main.java.finalproject.service.EkosistemService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException {

        EkosistemService ekosistemService = new EkosistemService(KoneksiDB.getKoneksi());
        ekosistemService.migrate();

    }

}
