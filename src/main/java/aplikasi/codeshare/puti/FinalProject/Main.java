package main.java.aplikasi.codeshare.puti.FinalProject;

import main.java.aplikasi.codeshare.puti.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Barang;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Faktur;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Pembeli;
import main.java.aplikasi.codeshare.puti.FinalProject.service.BarangService;
import main.java.aplikasi.codeshare.puti.FinalProject.service.FakturService;
import main.java.aplikasi.codeshare.puti.FinalProject.service.PembeliService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Barang barang = new Barang();
        barang.setNamaBarang("Meja");

        Pembeli pembeli = new Pembeli();
        pembeli.setNamaPembeli("Asep Marjuki");

        BarangService barangService = new BarangService(KoneksiDB.getKoneksi());
        barang = barangService.save(barang);

        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());
        pembeli = pembeliService.save(pembeli);

        Faktur faktur = new Faktur();
        faktur.setBarang(barang);
        faktur.setPembeli(pembeli);

        FakturService fakturService = new FakturService(KoneksiDB.getKoneksi());
        faktur = fakturService.save(faktur);

        System.out.println("FAKTUR : "+faktur.toString());

    }
}