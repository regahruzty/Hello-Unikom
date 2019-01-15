package main.java.aplikasi.codeshare.ariya.ariya_final;



import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.migration.Migration;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.*;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.*;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.println("1. Migrasi");
        System.out.println("2. Menu CRUD");

        if (input.nextInt() == 1){
            Migration.main(args);
        } else {
            System.out.println("1. Input Data");
            System.out.println("2. Edit Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Tampil All Data");

            if (input.nextInt() == 1){

            }
        }







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
        java.sql.Date dateSql = new java.sql.Date(new java.util.Date().getTime());
        transaksi.setTanggal_pembelian(dateSql);
        transaksi.setJumlah_pembelian((long) 5);

        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
        transaksi = transaksiService.save(transaksi);

        System.out.println("TRANSAKSI : "+transaksi.toString());

    }
}
