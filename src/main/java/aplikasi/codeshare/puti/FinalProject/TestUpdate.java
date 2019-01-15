package main.java.aplikasi.codeshare.puti.FinalProject;

import main.java.aplikasi.codeshare.puti.FinalProject.config.KoneksiDB;
import main.java.aplikasi.codeshare.puti.FinalProject.model.Barang;
import main.java.aplikasi.codeshare.puti.FinalProject.service.BarangService;

import java.sql.SQLException;
import java.util.List;

public class TestUpdate {
    public static void main(String[] args) throws SQLException {

        BarangService barangService = new BarangService(KoneksiDB.getKoneksi());

        Barang buku = new Barang();
        buku.setIdBarang(2L);
        buku.setNamaBarang("Buku");

        barangService.update(buku);

        Barang pensil = new Barang();
        pensil.setIdBarang(3L);
        pensil.setNamaBarang("Pensil");

        barangService.update(pensil);

        List<Barang> barangs = barangService.findAll();

        for(Barang barang : barangs){
            System.out.println(barangs.toString());
        }



    }
}
