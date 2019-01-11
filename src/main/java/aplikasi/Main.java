package main.java.aplikasi;

import main.java.aplikasi.service.KucingService;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        KucingService kucingService = new KucingService();
        try {
            kucingService.selectKucing();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

