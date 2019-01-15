package main.java.aplikasi.codeshare.herdi;

import main.java.aplikasi.codeshare.herdi.config.KoneksiDB;
import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.model.Jenis;
import main.java.aplikasi.codeshare.herdi.model.Sifat;
import main.java.aplikasi.codeshare.herdi.service.BurungService;
import main.java.aplikasi.codeshare.herdi.service.JenisService;
import main.java.aplikasi.codeshare.herdi.service.JoinedHerdiService;
import main.java.aplikasi.codeshare.herdi.service.SifatService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {
    public static void main(String[] args) throws SQLException {

        JoinedHerdiService joinedHerdiService = new JoinedHerdiService(KoneksiDB.getKoneksi());
        BurungService burungService = new BurungService(KoneksiDB.getKoneksi());
        JenisService jenisService = new JenisService(KoneksiDB.getKoneksi());
        SifatService sifatService = new SifatService(KoneksiDB.getKoneksi());

        List<Burung> burungList = new ArrayList<>();
        Burung burung = new Burung();

        burungList = burungService.findAll();

        burung = burungList.get(0);

        List<Jenis> jenisList = new ArrayList<>();
        Jenis jenis = new Jenis();

        jenisList = jenisService.findAll();

        jenis = jenisList.get(0);

        List<Sifat> sifatList = new ArrayList<>();
        Sifat sifat = new Sifat();

        sifatList = sifatService.findAll();

        sifat = sifatList.get(0);

        joinedHerdiService.deleteByIdBurungIdJenisIdSifat(burung.getId_burung(),jenis.getId_jenis(), sifat.getId_sifat());

        List<Burung> burungList1 = burungService.findAll();

        System.out.println(burungList1.toString());

    }
}
