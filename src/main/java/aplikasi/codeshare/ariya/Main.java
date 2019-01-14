package main.java.aplikasi.codeshare.ariya;//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import main.java.aplikasi.codeshare.ariya.model.*;
import main.java.aplikasi.codeshare.ariya.service.*;
import main.java.aplikasi.codeshare.ariya.config.*;

public class Main {

    public static void main(String[] args) {
        TransaksiService transaksiService = new TransaksiService(KoneksiDB.getDataSource());



        try {
            Transaksi transaksi = new Transaksi();
            transaksi.setId_pembeli(2);
            transaksi.setId_motor(1);
            transaksi.setTanggal_pembelian("2019-01-14");
            transaksi.setJumlah_pembelian(5);
            transaksi = transaksiService.save(transaksi);
            System.out.println(transaksi.toString());
            System.out.println("Data Transaksi Tertambah");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
