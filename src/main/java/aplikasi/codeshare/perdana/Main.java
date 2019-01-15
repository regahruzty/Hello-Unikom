package main.java.aplikasi.codeshare.perdana;



import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.model.Jenis;
import main.java.aplikasi.codeshare.perdana.model.Joined_ID;
import main.java.aplikasi.codeshare.perdana.model.Kondisi;
import main.java.aplikasi.codeshare.perdana.model.Produk;
import main.java.aplikasi.codeshare.perdana.service.JenisService;
import main.java.aplikasi.codeshare.perdana.service.Joined_IDService;
import main.java.aplikasi.codeshare.perdana.service.KondisiService;
import main.java.aplikasi.codeshare.perdana.service.ProdukService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        Produk produk = new Produk();
        produk.setNama("Camry");
        produk.setMerk("Toyota");
        produk.setWaktu_pembuatan("2019-01-01");

        ProdukService produkService = new ProdukService(KoneksiDB.getKoneksi());
        produk = produkService.save(produk);

        System.out.println("Produk : "+produk.toString());

        Kondisi kondisi = new Kondisi();
        kondisi.setBody("Mulus");
        kondisi.setMesin("Normal");
        kondisi.setCreate_date("2019-01-01");

        KondisiService kondisiService = new KondisiService(KoneksiDB.getKoneksi());
        kondisi = kondisiService.save(kondisi);

        System.out.println("Produk : "+kondisi.toString());

        Jenis jenis = new Jenis();
        jenis.setJenis("Sedan");
        jenis.setKeterangan("Mobil paling nyaman");

        JenisService jenisService = new JenisService(KoneksiDB.getKoneksi());
        jenis = jenisService.save(jenis);

        System.out.println("Produk : "+jenis.toString());

        Joined_ID joined_id = new Joined_ID();
        joined_id.setProduk(produk);
        joined_id.setJenis(jenis);
        joined_id.setKondisi(kondisi);

        Joined_IDService joined_idService = new Joined_IDService(KoneksiDB.getKoneksi());
        joined_id = joined_idService.save(joined_id);

        System.out.println("Joined_ID : "+joined_id.toString());
    }

}
