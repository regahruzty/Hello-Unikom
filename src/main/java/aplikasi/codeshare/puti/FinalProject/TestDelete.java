package main.java.aplikasi.codeshare.puti.FinalProject;

import main.java.aplikasi.codeshare.puti.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Barang;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Faktur;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Pembeli;
import main.java.aplikasi.codeshare.puti.FinalProject.service.BarangService;
import main.java.aplikasi.codeshare.puti.FinalProject.service.FakturService;
import main.java.aplikasi.codeshare.puti.FinalProject.service.PembeliService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {
    public static void main(String[] args) throws SQLException {

        FakturService fakturService = new FakturService(KoneksiDB.getKoneksi());
        BarangService barangService = new BarangService(KoneksiDB.getKoneksi());
        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());

        List<Barang> barangs = new ArrayList<>();
        Barang barang = new Barang();

        barangs = barangService.findAll();

        barang = barangs.get(0);

        List<Pembeli> pembelis = new ArrayList<>();
        Pembeli pembeli = new Pembeli();

        pembelis = pembeliService.findAll();

        pembeli = pembelis.get(0);

        fakturService.deleteByIdBarangAndIdPembeli(barang.getIdBarang(), pembeli.getIdPembeli());

        List<Faktur> fakturs = fakturService.findAll();

        System.out.println(fakturs.toString());


    }

}
