package main.java.aplikasi.codeshare.ariya.ariya_final;

import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Motor;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Transaksi;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.MotorService;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.PembeliService;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.TransaksiService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        MotorService motorService = new MotorService(KoneksiDB.getKoneksi());
        PembeliService pembeliService= new PembeliService(KoneksiDB.getKoneksi());

        List<Motor> motorList= new ArrayList<>();
        Motor motor = new Motor();

        motorList= motorService.findAll();

        motor = motorList.get(0);

        List<Pembeli> pembeliList= new ArrayList<>();
        Pembeli pembeli = new Pembeli();

        pembeliList= pembeliService.findAll();

        pembeli = pembeliList.get(0);

        transaksiService.deleteByIdMotorAndIdPembeli(motor.getId_motor(), pembeli.getId_pembeli());

        List<Transaksi> transaksiList = transaksiService.findAll();

        System.out.println(transaksiList.toString());




    }
}

