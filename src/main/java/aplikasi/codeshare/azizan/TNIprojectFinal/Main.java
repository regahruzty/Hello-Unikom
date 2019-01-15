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

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        String namaTentara;
        namaTentara = JOptionPane.showInputDialog("Masukkan Nama Tentara");

        String pangkat;
        pangkat = JOptionPane.showInputDialog("Mmasukkan Pangkat Tentara");

        String matra;
        matra = JOptionPane.showInputDialog("Masukkan Matra Tentara");

        Boolean perwira;
        perwira = Boolean.valueOf(JOptionPane.showInputDialog("Apakah Seorang Perwira?"));

        String statusTentara;
        statusTentara = JOptionPane.showInputDialog("Masukkan Status Tentara");

        String namaBatalyon;
        namaBatalyon = JOptionPane.showInputDialog("Masukkan Nama Batalyon");

        Tentara tentara = new Tentara();
        tentara.setNamaTentara(namaTentara);
        tentara.setPangkat(pangkat);
        tentara.setMatra(matra);
        tentara.setPerwira(perwira);

        TentaraAktif tentaraAktif = new TentaraAktif();
        tentaraAktif.setStatusTentara(statusTentara);

        Batalyon batalyon = new Batalyon();
        batalyon.setNamaBatalyon(namaBatalyon);

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
