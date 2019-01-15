package main.java.aplikasi.codeshare.herdi;
import main.java.aplikasi.codeshare.herdi.config.KoneksiDB;
import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.model.Jenis;
import main.java.aplikasi.codeshare.herdi.model.JoinedHerdi;
import main.java.aplikasi.codeshare.herdi.model.Sifat;
import main.java.aplikasi.codeshare.herdi.service.BurungService;
import main.java.aplikasi.codeshare.herdi.service.JenisService;
import main.java.aplikasi.codeshare.herdi.service.JoinedHerdiService;
import main.java.aplikasi.codeshare.herdi.service.SifatService;

import java.sql.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {

        Burung burung = new Burung();
        burung.setNama("Elang");
        burung.setWarna("Coklat");
        burung.setParuh("Kuat, Tajam");

        Jenis jenis = new Jenis();
        jenis.setJenis("Jawa");
        jenis.setDesc_jenis("Elang jawa merupakan elang yang berasal dari jawa");

        Sifat sifat = new Sifat();
        sifat.setSifat("Liar");
        sifat.setDesc_sifat("Elang jawa mempunyai sifat liar");

        BurungService burungService = new BurungService(KoneksiDB.getKoneksi());
        burung = burungService.save(burung);

        JenisService jenisService = new JenisService(KoneksiDB.getKoneksi());
        jenis = jenisService.save(jenis);

        SifatService sifatService = new SifatService(KoneksiDB.getKoneksi());
        sifat = sifatService.save(sifat);

        JoinedHerdi joinedHerdi = new JoinedHerdi();
        joinedHerdi.setBurung(burung);
        joinedHerdi.setJenis(jenis);
        joinedHerdi.setSifat(sifat);

        JoinedHerdiService joinedHerdiService = new JoinedHerdiService(KoneksiDB.getKoneksi());
        joinedHerdi = joinedHerdiService.save(joinedHerdi);

        System.out.println("Joined Herdi "+joinedHerdi.toString());
    }
    }

