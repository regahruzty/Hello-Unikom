package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Migration;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TNIService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException{
        TNIService tniService = new TNIService(KoneksiDB.getKoneksi());
        tniService.migrate();
    }

}
