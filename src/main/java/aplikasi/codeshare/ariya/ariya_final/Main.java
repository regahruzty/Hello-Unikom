package main.java.aplikasi.codeshare.ariya.ariya_final;



import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.migration.Migration;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.*;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static javax.swing.JOptionPane.showInputDialog;


public class Main {

    public static void main(String[] args) throws SQLException {
        Motor motor = new Motor();
        Pembeli pembeli = new Pembeli();
        Transaksi transaksi = new Transaksi();
        Scanner input = new Scanner(System.in);
        java.sql.Date dateSql = new java.sql.Date(new java.util.Date().getTime());

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
                        List<Motor> motorList= new ArrayList<>();
                        motorList = motorService.findAll();

                        for (Motor motors: motorList) {
//
                            System.out.println("======================================");
                            System.out.println("id_motor: " + motors.getId_motor());
                            System.out.println("nama_motor: " + motors.getNama_motor());
                            System.out.println("merk_motor: " + motors.getMerk_motor());
                            System.out.println("======================================");
                        }
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
                        List<Pembeli> pembeliList= new ArrayList<>();
                        pembeliList = pembeliService.findAll();

                        for (Pembeli pembelis : pembeliList) {
//
                            System.out.println("======================================");
                            System.out.println("id_pembeli: " + pembelis.getId_pembeli());
                            System.out.println("nama_pembeli: " + pembelis.getNama_pembeli());
                            System.out.println("alamat_pembeli: " + pembelis.getAlamat_pembeli());
                            System.out.println("======================================");
                        }


                }
            } else if (pilihMenu == 3){
                System.out.println("1. Tambah Data Transaksi");
                System.out.println("2. Hapus Data Transaksi");
                System.out.println("3. Edit Data Transaksi");
                System.out.println("4. Tampil Data Transaksi");
                TransaksiService transaksiService = new TransaksiService(KoneksiDB.getKoneksi());
                int pilihMenuTransaksi = input.nextInt();
                switch (pilihMenuTransaksi){
                    case 1 :
                        pembeli.setId_pembeli(Long.parseLong(showInputDialog("Masukkan ID Pembeli : ")));
                        motor.setId_motor(Long.parseLong(showInputDialog("Masukkan ID Motor: ")));
                        transaksi.setTanggal_pembelian(dateSql);
                        transaksi.setJumlah_pembelian(Long.parseLong(showInputDialog("Masukkan Jumlah Pembelian: ")));
                        transaksi.setPembeli(pembeli);
                        transaksi.setMotor(motor);
                        transaksiService.save(transaksi);
                        JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Ditambah");
                        break;
                    case 2 :
                        transaksi.setId_transaksi(Long .parseLong(showInputDialog("Masukkan Id Transaksi : ")));
                        transaksiService.delete(transaksi.getId_transaksi());
                        JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Dihapus");
                        break;
                    case 3 :
                        transaksi.setId_transaksi(Long.parseLong(showInputDialog("Masukkan ID Transaksi : ")));
                        pembeli.setId_pembeli(Long.parseLong(showInputDialog("Masukkan ID Pembeli ")));
                        motor.setId_motor(Long.parseLong(showInputDialog("Masukkan ID Motor  ")));
                        transaksi.setTanggal_pembelian(dateSql);
                        transaksi.setJumlah_pembelian(Long.parseLong(showInputDialog("Masukkan Jumlah Pembelian")));
                        transaksi.setPembeli(pembeli);
                        transaksi.setMotor(motor);
                        transaksiService.update(transaksi);
                        JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Diubah ");
                        break;
                    case 4 :
                        List<Transaksi> transaksiList= new ArrayList<>();
                        transaksiList = transaksiService.findAll();

                        for (Transaksi transaksis : transaksiList) {
//
                        System.out.println("======================================");
                        System.out.println("id_transaksi: " + transaksis.getId_transaksi());
                        System.out.println("merk_motor: " + transaksis.getMotor().getMerk_motor());
                        System.out.println("nama_motor: " + transaksis.getMotor().getNama_motor());
                        System.out.println("nama_pembeli: " + transaksis.getPembeli().getNama_pembeli());
                        System.out.println("Alamat Pembeli: " + transaksis.getPembeli().getAlamat_pembeli());
                        System.out.println("jumlah_pembelian: " + transaksis.getJumlah_pembelian());
                        System.out.println("tanggal_pembelian: " + transaksis.getTanggal_pembelian());
                        System.out.println("======================================");
                        }


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
