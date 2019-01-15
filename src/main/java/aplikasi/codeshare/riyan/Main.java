package main.java.aplikasi.codeshare.riyan;

import main.java.aplikasi.codeshare.riyan.config.KoneksiDB;
import main.java.aplikasi.codeshare.riyan.model.Boothcamp;
import main.java.aplikasi.codeshare.riyan.model.Joined_id_riyan;
import main.java.aplikasi.codeshare.riyan.model.Pengajar;
import main.java.aplikasi.codeshare.riyan.model.Peserta;
import main.java.aplikasi.codeshare.riyan.service.BoothcampService;
import main.java.aplikasi.codeshare.riyan.service.JoinedIDRiyanService;
import main.java.aplikasi.codeshare.riyan.service.PengajarService;
import main.java.aplikasi.codeshare.riyan.service.PesertaService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Boothcamp boothcamp = new Boothcamp();
        boothcamp.setNama_boothcamp("Java Developer Boothcamp Multipolar");
        boothcamp.setLokasi("UNIKOM");
        boothcamp.setAlamat("Jln. Dipatiukur No 112-114");


        Pengajar pengajar = new Pengajar();
        pengajar.setNama_pengajar("Anne");
        pengajar.setNo_telp("087222314567");
        pengajar.setSpesialis("JAVA");

        Peserta peserta = new Peserta();
        peserta.setNama_peserta("Agung Eka Lukmantara");
        peserta.setNo_telp("087832910293");
        peserta.setAlamat("Kubang Utara No 23");


        BoothcampService boothcampService = new BoothcampService(KoneksiDB.getKoneksi());
        boothcamp = boothcampService.save(boothcamp);

        PengajarService pengajarService = new PengajarService(KoneksiDB.getKoneksi());
        pengajar = pengajarService.save(pengajar);

        PesertaService pesertaService = new PesertaService(KoneksiDB.getKoneksi());
        peserta = pesertaService.save(peserta);

        Joined_id_riyan joined_id_riyan = new Joined_id_riyan();
        joined_id_riyan.setBoothcamp(boothcamp);
        joined_id_riyan.setPengajar(pengajar);
        joined_id_riyan.setPeserta(peserta);

        //JoinedIDRiyanService joinedIDRiyanService = new JoinedIDRiyanService(KoneksiDB.getKoneksi());
        JoinedIDRiyanService joinedIDRiyanService = new JoinedIDRiyanService(KoneksiDB.getKoneksi());
        joined_id_riyan = joinedIDRiyanService.save(joined_id_riyan);

        System.out.println("Joined Id RIYAN : "+joined_id_riyan.toString());




    }
}