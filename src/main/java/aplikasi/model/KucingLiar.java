package main.java.aplikasi.model;

import java.util.Date;

//bootcampuniko-qp89079
public class KucingLiar extends Kucing {
    public KucingLiar() {
        setJenis("Kampung");
        setJumlahKaki(3);
        setLiar(false);
        setNama("JON");
        setTanggalLahir(new Date());
    }

    public void describe() {
        System.out.println("INI VALUE DARI KUCING LIAR :");
        System.out.println("INI NAMA DARI KUCING LIAR -> " + new KucingLiar().getNama());
        System.out.println("INI JUMLAH KAKI DARI KUCING LIAR -> " + new KucingLiar().getJumlahKaki());
        System.out.println("INI JENIS DARI KUCING LIAR -> " + new KucingLiar().getJenis());
        System.out.println("KUCING LIAR INI LAHIR PADA -> " + new KucingLiar().getTanggalLahir());
        System.out.println("KUCING LIAR INI BERSIFAT -> " + (new KucingLiar().getLiar() ? "LIAR" : "TIDAK LIAR"));
    }

    public void describe(String punyaSiapa) {
        System.out.println("INI VALUE DARI KUCING LIAR :");
        System.out.println("KUCING INI ADALAH MILIK -> " + punyaSiapa);
    }
}
