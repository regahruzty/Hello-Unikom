package main.java.aplikasi.codeshare.robby.FinalProject;

import main.java.aplikasi.codeshare.robby.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.robby.FinalProject.model.Komputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.PemilikKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.TipeKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.Transaksi;
import main.java.aplikasi.codeshare.robby.FinalProject.service.KomputerService;
import main.java.aplikasi.codeshare.robby.FinalProject.service.PemilikKomputerService;
import main.java.aplikasi.codeshare.robby.FinalProject.service.TipeKomputerService;
import main.java.aplikasi.codeshare.robby.FinalProject.service.TransaksiService;

import java.sql.SQLException;
import java.util.List;

public class TestDelete {
    public static void main(String[] args) throws SQLException {

        KomputerService komputerService = new KomputerService(KoneksiDB.getKoneksi());
        PemilikKomputerService pemilikKomputerService = new PemilikKomputerService(KoneksiDB.getKoneksi());
        TipeKomputerService tipeKomputerService = new TipeKomputerService(KoneksiDB.getKoneksi());
        TransaksiService transaksiService  = new TransaksiService(KoneksiDB.getKoneksi());

        List<Komputer> komputers = komputerService.findAll();
        Komputer komputer = komputers.get(0);
        System.out.println(komputer);

        List<PemilikKomputer> pemilikKomputers = pemilikKomputerService.findAll();
        PemilikKomputer pemilikKomputer = pemilikKomputers.get(0);
        System.out.println(pemilikKomputer);

        List<TipeKomputer> tipeKomputerlist = tipeKomputerService.findAll();
        //System.out.println(tipeKomputerlist);

        List<Transaksi> transaksis = transaksiService.findAll();
        System.out.println(transaksis);

        transaksiService.deleteByIdKomputerDanPemilik(komputer.getId_komputer(), pemilikKomputer.getId_pemilik_komputer());

        System.out.println(transaksis);
    }
}
