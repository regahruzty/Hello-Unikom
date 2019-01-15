package main.java.aplikasi.codeshare.puti.FinalProject;

import config.KoneksiDB;
import model.Barang;
import model.Faktur;
import model.Pembeli;
import service.BarangService;
import service.FakturService;
import service.PembeliService;

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
