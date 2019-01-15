package main.java.aplikasi.codeshare.robby.FinalProject;

import main.java.aplikasi.codeshare.robby.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.robby.FinalProject.model.Komputer;
import main.java.aplikasi.codeshare.robby.FinalProject.service.KomputerService;

import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {
        java.sql.Date datesql =new java.sql.Date(new java.util.Date().getTime());
        KomputerService komputerService = new KomputerService(KoneksiDB.getKoneksi());

        Komputer komputer = new Komputer();
        komputer.setId_komputer(1L);
        komputer.setMerk("Apple");
        komputer.setTanggalBangun(datesql);
        System.out.println(komputer);

        komputerService.update(komputer);
    }
}
