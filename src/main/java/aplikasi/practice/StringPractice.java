package main.java.aplikasi.practice;

import main.java.aplikasi.model.Kucing;

import java.util.ArrayList;
import java.util.List;

public class StringPractice {

    public static void main(String[] args) {

        List<Kucing> kucingDiRumah = new ArrayList<>();
        String narasi = "";

        Kucing kucing = new Kucing();
        Kucing kucingLiar = new Kucing();
        Kucing kucingRumah = new Kucing();

        kucing.setJenis("Persian");
        kucing.setNama("Gary");
        kucing.setJumlahKaki(5);

        kucingLiar.setJenis("Angora");
        kucingLiar.setNama("Sammy");
        kucingLiar.setJumlahKaki(5);

        kucingRumah.setJenis("Kuning");
        kucingRumah.setNama("Garry");
        kucingRumah.setJumlahKaki(5);

        kucingDiRumah.add(kucing);
        kucingDiRumah.add(kucingLiar);
        kucingDiRumah.add(kucingRumah);
        kucingDiRumah.add(kucingRumah);

        for(int i = 0; i < kucingDiRumah.size(); i++){
            if(i == 1) {
                narasi = "Dahulu kala ada kucing yang bernama " + kucingDiRumah.get(0).getNama() + " dan dia berjenis " + kucingDiRumah.get(0).getJenis() + " juga jumlah kakinya ialah " + String.valueOf(kucingDiRumah.get(0).getJumlahKaki());
            } else if (i == 2){
                narasi = narasi + " Lalu masuklah kucing liar yang bernama "+ kucingDiRumah.get(1).getNama()+ " dan dia berjenis "+ kucingDiRumah.get(1).getJenis();
            }
        }

        System.out.println(narasi);


    }
}