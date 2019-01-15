package main.java.aplikasi.codeshare.ariya.ariya_final;



import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.*;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Motor motor = new Motor();
        motor.setNama_motor("Jupiter MX");
        motor.setMerk_motor("Yamaha");

        Pembeli pembeli = new Pembeli();
        pembeli.setNama_pembeli("Ariya Agustian");
        pembeli.setAlamat_pembeli("Babakan Tarogong");

        MotorService motorService = new MotorService(KoneksiDB.getKoneksi());
        motor = motorService.save(motor);

        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());
        pembeli = pembeliService.save(pembeli);

        Transaksi transaksi = new Transaksi();
        transaksi.setMotor(motor);
        transaksi.setPembeli(pembeli);

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        transaksi = transaksiService.save(transaksi);

        System.out.println("TRANSAKSI : "+transaksi.toString());

    }
}
