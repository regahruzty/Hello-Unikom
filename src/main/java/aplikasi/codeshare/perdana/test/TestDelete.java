package main.java.aplikasi.codeshare.perdana.test;
import config.KoneksiDB;
import model.Produk;
import service.ProdukService;

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
