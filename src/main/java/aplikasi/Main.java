package main.java.aplikasi;

import main.java.aplikasi.config.KoneksiDB;
import main.java.aplikasi.model.Kucing;
import main.java.aplikasi.service.KucingService;

import java.sql.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        KucingService kucingService = new KucingService(KoneksiDB.getDataSourceMysqlLearnJDBC());
        try {
            Kucing kucing = new Kucing();

            kucing.setNama("Jasmine");
            kucing.setJenis("Scottish Fold");
            kucing.setLiar(false);
               kucing.setJumlahKaki(4);

            kucing.setTanggalLahir(new Date());

            kucing = kucingService.save(kucing);
            System.out.println(kucing.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

