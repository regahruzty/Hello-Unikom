package main.java.aplikasi.codeshare.perdana.test;



import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.model.Kondisi;
import main.java.aplikasi.codeshare.perdana.service.KondisiService;

import java.sql.SQLException;

public class TestSave {

    public static void main(String[] args) throws SQLException {
        Kondisi save = new Kondisi();
        save.setBody("Mulus");
        save.setMesin("Mulus");
        save.setCreate_date("2019-01-01");

        KondisiService saveService = new KondisiService(KoneksiDB.getKoneksi());
        save = saveService.save(save);

        System.out.println("Kondisi : "+save.toString());
    }

}

