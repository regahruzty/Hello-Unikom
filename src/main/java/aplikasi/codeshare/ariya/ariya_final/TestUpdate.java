package main.java.aplikasi.codeshare.ariya.ariya_final;

import main.java.aplikasi.codeshare.ariya.ariya_final.config.KoneksiDB;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Motor;
import main.java.aplikasi.codeshare.ariya.ariya_final.service.MotorService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        MotorService motorService = new MotorService(KoneksiDB.getKoneksi());

        Motor beat = new Motor();
        beat.setId_motor(3L);
        beat.setNama_motor("Beat CW");
        beat.setMerk_motor("Honda");

        motorService.update(beat);

        Motor Jupiter = new Motor();
        Jupiter.setId_motor(2L);
        Jupiter.setNama_motor("Jupiter Z CW");
        Jupiter.setMerk_motor("Yamaha");

        motorService.update(Jupiter);

        List<Motor> motorList= motorService.findAll();

        for(Motor motor : motorList){
            System.out.println(motorList.toString());
        }



    }
}
