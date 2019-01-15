package main.java.aplikasi.codeshare.puspa.FinalProject;

import config.KoneksiDB;
import model.Fire;
import service.FireService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

        public static void main(String[] args) throws SQLException {

            FireService fireService = new FireService(KoneksiDB.getKoneksi());

            Fire rapidash = new Fire();
            rapidash.setIdFire(2L);
            rapidash.setNamaFire("Rapidash");

            fireService.update(rapidash);

            Fire flareon = new Fire();
            flareon.setIdFire(3L);
            flareon.setNamaFire("Flareon");

            fireService.update(flareon);

            List<Fire> fires = fireService.findAll();

            for(Fire fire : fires){
                System.out.println(fires.toString());
            }



        }
    }
