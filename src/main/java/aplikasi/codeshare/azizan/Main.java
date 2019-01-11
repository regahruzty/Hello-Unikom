package main.java.aplikasi.codeshare.azizan;
import main.java.aplikasi.codeshare.azizan.Services.NarasiService;

import java.sql.*;

public class Main {

    public static void main (String[] args){
        NarasiService narasi = new NarasiService();
        try {
            NarasiService.Menarasikan();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
