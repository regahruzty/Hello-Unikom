package main.java.aplikasi.codeshare.perdana.test;



import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.model.Produk;
import main.java.aplikasi.codeshare.perdana.service.ProdukService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {

    public static void main(String[] args) throws SQLException {

        ProdukService produkService = new ProdukService(KoneksiDB.getKoneksi());

        Produk gajah = new Produk();
        gajah.setId_produk(2);
        gajah.setNama("Gajah");
        gajah.setMerk("Toyota");
        gajah.setWaktu_pembuatan("2019-02-02");

        produkService.update(gajah);

        Produk jerapah = new Produk();
        jerapah.setId_produk(3);
        jerapah.setNama("Jerapah");
        jerapah.setMerk("Toyota");
        jerapah.setWaktu_pembuatan("2019-02-02");

        produkService.update(jerapah);

        List<Produk> produks = produkService.findAll();
    }
}

