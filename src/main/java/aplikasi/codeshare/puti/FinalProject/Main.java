package main.java.aplikasi.codeshare.puti.FinalProject;

import config.KoneksiDB;
import model.Barang;
import model.Faktur;
import model.Pembeli;
import service.BarangService;
import service.FakturService;
import service.PembeliService;

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