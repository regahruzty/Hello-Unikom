package main.java.aplikasi.codeshare.perdana.test;



import main.java.aplikasi.codeshare.perdana.config.KoneksiDB;
import main.java.aplikasi.codeshare.perdana.model.Produk;
import main.java.aplikasi.codeshare.perdana.service.ProdukService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDelete {

    public static void main(String[] args) throws SQLException {

        ProdukService produkService = new ProdukService(KoneksiDB.getKoneksi());

        List<Produk> produks = new ArrayList<>();
        Produk produk = new Produk();
        produks = produkService.findAll();
        produk = produks.get(0);
        produkService.delete(produk.getId_produk());
        System.out.println(produks.toString());
    }
}
