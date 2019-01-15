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

public class Main{

    public static void main(String[] args) throws SQLException {
        java.sql.Date datesql =new java.sql.Date(new java.util.Date().getTime());

        Komputer komputer1 = new Komputer();
        komputer1.setMerk("asus");
        komputer1.setTanggalBangun(datesql);

        PemilikKomputer pemilikKomputer1 = new PemilikKomputer();
        pemilikKomputer1.setNama_pemilik_komputer("Agus");

        TipeKomputer tipeKomputer1 = new TipeKomputer();
        tipeKomputer1.setNama_tipe("laptop");

        KomputerService komputerService = new KomputerService(KoneksiDB.getKoneksi());
        komputer1 = komputerService.save(komputer1);

        PemilikKomputerService pemilikKomputerService = new PemilikKomputerService(KoneksiDB.getKoneksi());
        pemilikKomputer1 = pemilikKomputerService.save(pemilikKomputer1);

        TipeKomputerService tipeKomputerService = new TipeKomputerService(KoneksiDB.getKoneksi());
        tipeKomputer1 = tipeKomputerService.save(tipeKomputer1);

        Transaksi transaksi1 = new Transaksi();
        transaksi1.setKomputer(komputer1);
        transaksi1.setPemilikKomputer(pemilikKomputer1);
        transaksi1.setTipeKomputer(tipeKomputer1);

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        transaksi1 = transaksiService.save(transaksi1);

        System.out.println(transaksi1.toString());

    }

}