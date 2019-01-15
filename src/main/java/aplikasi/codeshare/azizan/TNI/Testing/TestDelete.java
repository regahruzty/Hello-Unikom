package main.java.aplikasi.codeshare.azizan.TNI.Testing;

import main.java.aplikasi.codeshare.azizan.TNI.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Model.Batalyon;
import main.java.aplikasi.codeshare.azizan.TNI.Model.TNI;
import main.java.aplikasi.codeshare.azizan.TNI.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNI.Model.TentaraAktif;
import main.java.aplikasi.codeshare.azizan.TNI.Service.BatalyonService;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TNIService;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TentaraAktifService;
import main.java.aplikasi.codeshare.azizan.TNI.Service.TentaraService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        TNIService tniService = new TNIService(KoneksiDB.getKoneksi());
        TentaraService tentaraService = new TentaraService(KoneksiDB.getKoneksi());
        TentaraAktifService tentaraAktifService = new TentaraAktifService(KoneksiDB.getKoneksi());
        BatalyonService batalyonService = new BatalyonService(KoneksiDB.getKoneksi());

        List<Tentara> tentaras = new ArrayList<>();
        Tentara tentara = new Tentara();
        tentaras = tentaraService.findAll();
        tentara = tentaras.get(0);

        List<TentaraAktif> tentaraAktifs = new ArrayList<>();
        TentaraAktif tentaraAktif = new TentaraAktif();
        tentaraAktifs = tentaraAktifService.findAll();
        tentaraAktif = tentaraAktifs.get(0);

        List<Batalyon> batalyons = new ArrayList<>();
        Batalyon batalyon = new Batalyon();
        batalyons = batalyonService.findAll();
        batalyon = batalyons.get(0);

        tniService.deleteByIdTentaraAndIdTentaraAktifAndIdBatalyon(tentara.getIdTentara(), tentaraAktif.getIdTentaraAktif(), batalyon.getIdBayalyon());

        List<TNI> tnis = tniService.findAll();

        System.out.println(tnis.toString());

    }

}
