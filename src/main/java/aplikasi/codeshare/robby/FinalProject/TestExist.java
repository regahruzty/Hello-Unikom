package main.java.aplikasi.codeshare.robby.FinalProject;

import main.java.aplikasi.codeshare.robby.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.robby.FinalProject.model.Komputer;
import main.java.aplikasi.codeshare.robby.FinalProject.service.KomputerService;

import java.sql.SQLException;

public class TestExist {
    public static void main(String[] args) throws SQLException {
        KomputerService komputerService = new KomputerService(KoneksiDB.getKoneksi());

        Komputer komputer = new Komputer();
        komputer.setId_komputer(1L);

        System.out.println(komputerService.exists(komputer.getId_komputer()) ? "ada" : "tidak ada");
    }
}
