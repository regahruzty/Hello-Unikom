package main.java.aplikasi.codeshare.gedha;

import main.java.aplikasi.codeshare.gedha.config.KoneksiDB;
import main.java.aplikasi.codeshare.gedha.model.Buku;
import main.java.aplikasi.codeshare.gedha.model.Koleksi;
import main.java.aplikasi.codeshare.gedha.model.Komik;
import main.java.aplikasi.codeshare.gedha.model.Majalah;
import main.java.aplikasi.codeshare.gedha.service.BukuService;
import main.java.aplikasi.codeshare.gedha.service.KoleksiService;
import main.java.aplikasi.codeshare.gedha.service.KomikService;
import main.java.aplikasi.codeshare.gedha.service.MajalahService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Buku buku = new Buku();
        buku.setJudul_buku("Hary Potey");
        buku.setPengarang("JK-R");
        buku.setTanggal_terbit("2011");
        BukuService bukuService =new BukuService(KoneksiDB.getKoneksi());
        buku = bukuService.save(buku);

        Komik komik = new Komik();
        komik.setJudul_komik("Captain Tsubasa");
        komik.setPengarang("Momon");
        komik.setTanggal_terbit("2016");
        KomikService komikService = new KomikService(KoneksiDB.getKoneksi());
        komik = komikService.save(komik);

        Majalah majalah = new Majalah();
        majalah.setJudul_majalah("Rakyat");
        majalah.setPengarang("Dari Rakyat");
        majalah.setTanggal_terbit("2019");
        MajalahService majalahService = new MajalahService(KoneksiDB.getKoneksi());
        majalah = majalahService.save(majalah);

        Koleksi koleksi = new Koleksi();
//        koleksi.setId_koleksi(koleksi);
        koleksi.setBuku(buku);
        koleksi.setKomik(komik);
        koleksi.setMajalah(majalah);

        KoleksiService koleksiService = new KoleksiService(KoneksiDB.getKoneksi());
        koleksi = koleksiService.save(koleksi);

        System.out.println("KOLEKSI :"+koleksi.toString());

    }
}
