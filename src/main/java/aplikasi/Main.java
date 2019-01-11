package main.java.aplikasi;

import main.java.aplikasi.service.KucingService;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        KucingService kucingService = new KucingService();
        try {
            kucingService.selectPemilikKucing();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

