package main.java.aplikasi.codeshare.azizan;

import main.java.aplikasi.codeshare.azizan.Services.NarasiService;
import main.java.aplikasi.service.KucingService;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        NarasiService narasiService = new NarasiService();
        try {
            narasiService.Menarasikan();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


