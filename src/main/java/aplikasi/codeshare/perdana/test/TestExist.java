package main.java.aplikasi.codeshare.perdana.test;



import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.model.Produk;
import main.java.aplikasi.codeshare.perdana.service.ProdukService;

import java.sql.SQLException;

public class TestExist {

    public static void main(String[] args) throws SQLException {

        ProdukService produkService = new ProdukService(KoneksiDB.getKoneksi());

        Produk produk = new Produk();
        produk.setId_produk(3);

        System.out.println(produkService.exists(produk.getId_produk()) ? "Seri 7 ada di tabel tumbuhan " : "Seri 7 tidak ada di tabel tumbuhan");




    }
}
