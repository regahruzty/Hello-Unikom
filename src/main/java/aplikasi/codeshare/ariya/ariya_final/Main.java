package main.java.aplikasi.codeshare.ariya.ariya_final;



import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.migration.Migration;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.*;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;


public class Main {

    public static void main(String[] args) throws SQLException {
        Motor motor = new Motor();
        Pembeli pembeli = new Pembeli();
        Transaksi transaksi = new Transaksi();
        Scanner input = new Scanner(System.in);

        System.out.println("1. Migrasi");
        System.out.println("2. Menu CRUD");
        int pilih = input.nextInt();
        if (pilih == 1){
            Migration.main(args);
        } else {
            System.out.println("1. CRUD Motor");
            System.out.println("2. CRUD Pembeli");
            System.out.println("3. CRUD Transaksi");
            int pilihMenu = input.nextInt();
            if (pilihMenu == 1){
                System.out.println("1. Tambah Data Motor");
                System.out.println("2. Hapus Data Motor");
                System.out.println("3. Edit Data Motor");
                System.out.println("4. Tampil Data Motor");
                MotorService motorService = new MotorService(KoneksiDB.getKoneksi());
                int pilihMenuMotor = input.nextInt();
                switch (pilihMenuMotor){
                    case 1 :
                        motor.setNama_motor(showInputDialog("Masukkan Nama Motor : "));
                        motor.setMerk_motor(showInputDialog("Masukkan Merk Motor : "));
                        motorService.save(motor);
                        JOptionPane.showMessageDialog(null, "Data Motor Berhasil Ditambah ");
                        break;
                    case 2 :
                        motor.setId_motor(Long .parseLong(showInputDialog("Masukkan Id Motor : ")));
                        motorService.delete(motor.getId_motor());
                        JOptionPane.showMessageDialog(null, "Data Motor Berhasil Dihapus");
                        break;
                    case 3 :
                        motor.setId_motor(Long .parseLong(showInputDialog("Masukkan Id Motor : ")));
                        motor.setNama_motor(showInputDialog("Masukkan Nama Motor : "));
                        motor.setMerk_motor(showInputDialog("Masukkan Merk Motor : "));
                        motorService.update(motor);
                        JOptionPane.showMessageDialog(null, "Data Motor Berhasil Diubah");
                        break;
                    case 4 :
                        System.out.println("Tampil Data Motor");
                        motorService.findAll().toString();
                }
            } else if (pilihMenu == 2){
                System.out.println("1. Tambah Data Pembeli");
                System.out.println("2. Hapus Data Pembeli");
                System.out.println("3. Edit Data Pembeli");
                System.out.println("4. Tampil Data Pembeli");
                PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());
                int pilihMenuPembeli = input.nextInt();
                switch (pilihMenuPembeli){
                    case 1 :
                        pembeli.setNama_pembeli(showInputDialog("Masukkan Nama Pembeli : "));
                        pembeli.setAlamat_pembeli(showInputDialog("Masukkan Alamat Pembeli : "));
                        pembeliService.save(pembeli);
                        JOptionPane.showMessageDialog(null, "Data Pembeli Berhasil Ditambah");
                        break;
                    case 2 :
                        System.out.println("Masukkan ID Pembeli : ");
                        pembeli.setId_pembeli(Long.parseLong(showInputDialog("Masukkan ID Pembeli : ")));
                        pembeliService.delete(pembeli.getId_pembeli());
                        JOptionPane.showMessageDialog(null, "Data Pembeli Berhasil Dihapus");
                        break;
                    case 3 :
                        pembeli.setId_pembeli(Long.parseLong(showInputDialog("Masukkan ID Pembeli : ")));
                        pembeli.setNama_pembeli(showInputDialog("Masukkan Nama Pembeli  "));
                        pembeli.setAlamat_pembeli(showInputDialog("Masukkan Alamat Pembeli "));
                        pembeliService.update(pembeli);
                        JOptionPane.showMessageDialog(null, "Data Pembeli Berhasil Diubah ");
                        break;
                    case 4 :
                        System.out.println("Tampil Data Motor");
                        pembeliService.findAll().toString();
                }
            }
        }




//
//
//
//        Motor motor = new Motor();
//        motor.setNama_motor("Jupiter MX");
//        motor.setMerk_motor("Yamaha");
//
//        Pembeli pembeli = new Pembeli();
//        pembeli.setNama_pembeli("Ariya Agustian");
//        pembeli.setAlamat_pembeli("Babakan Tarogong");
//
//        MotorService motorService = new MotorService(KoneksiDB.getKoneksi());
//        motor = motorService.save(motor);
//
//        PembeliService pembeliService = new PembeliService(KoneksiDB.getKoneksi());
//        pembeli = pembeliService.save(pembeli);
//
//        Transaksi transaksi = new Transaksi();
//        transaksi.setMotor(motor);
//        transaksi.setPembeli(pembeli);
//        java.sql.Date dateSql = new java.sql.Date(new java.util.Date().getTime());
//        transaksi.setTanggal_pembelian(dateSql);
//        transaksi.setJumlah_pembelian((long) 5);
//
//        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
//        transaksi = transaksiService.save(transaksi);
//
//        System.out.println("TRANSAKSI : "+transaksi.toString());

    }
}
