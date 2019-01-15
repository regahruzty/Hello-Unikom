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
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Masukkan nama tentara : ");
        Scanner scannerNamaTentara = new Scanner(System.in);
        String namaTentara = scannerNamaTentara.nextLine();

        System.out.println("Masukkan pangkat tentara : ");
        Scanner scannerPangkat = new Scanner(System.in);
        String pangkat = scannerPangkat.nextLine();

        System.out.println("Masukkan matra tentara : ");
        Scanner scannerMatra = new Scanner(System.in);
        String matra = scannerMatra.nextLine();

        System.out.println("apakah tentara perwira? ");
        Scanner scannerPerwira = new Scanner(System.in);
        Boolean perwira = Boolean.valueOf(scannerPerwira.nextLine());

        System.out.println("status tentara");
        Scanner scannerStatus = new Scanner(System.in);
        String statusTentara = scannerStatus.nextLine();

        System.out.println("nama batalyon tentara");
        Scanner scannerNamaBatalyon = new Scanner(System.in);
        String namaBatalyon = scannerNamaBatalyon.nextLine();

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
