package main.java.aplikasi.codeshare.azizan.TNIprojectFinal;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Batalyon;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.TNI;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.TentaraAktif;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.BatalyonService;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TNIService;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TentaraAktifService;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service.TentaraService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Tentara tentara = new Tentara();
        tentara.setNamaTentara("ujang");
        tentara.setPangkat("kolonel");
        tentara.setMatra("Angkatan Darat");
        tentara.setPerwira(true);

        TentaraAktif tentaraAktif = new TentaraAktif();
        tentaraAktif.setStatusTentara("aktif");

        Batalyon batalyon = new Batalyon();
        batalyon.setNamaBatalyon("Kompi A");

        TentaraService tentaraService = new TentaraService(KoneksiDB.getKoneksi());
        tentara = tentaraService.save(tentara);

        TentaraAktifService tentaraAktifService = new TentaraAktifService(KoneksiDB.getKoneksi());
        tentaraAktif = tentaraAktifService.save(tentaraAktif);

        BatalyonService batalyonService = new BatalyonService(KoneksiDB.getKoneksi());
        batalyon = batalyonService.save(batalyon);

        TNI tni = new TNI();
        tni.setTentara(tentara);
        tni.setBatalyon(batalyon);
        tni.setTentaraAktif(tentaraAktif);

        TNIService tniService = new TNIService(KoneksiDB.getKoneksi());
        tni = tniService.save(tni);

        System.out.println("TNIprojectFinal : " +tni.toString());



    }
}
