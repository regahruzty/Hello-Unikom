package main.java.aplikasi.codeshare.azizan.TNI.Migration;

import main.java.aplikasi.codeshare.azizan.TNI.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.TNIRepository;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TNIService;

import java.sql.SQLException;

public class Migration {

    public static void main(String[] args) throws SQLException{
        TNIService tniService = new TNIService(KoneksiDB.getKoneksi());
        tniService.migrate();
    }

}
