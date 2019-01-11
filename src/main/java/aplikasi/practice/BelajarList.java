package main.java.aplikasi.practice;

import main.java.aplikasi.model.Kucing;

import java.util.ArrayList;

public class BelajarList {

    public static void main(String[] args) {

        java.util.List<Kucing> kucingList = new ArrayList<>();

        java.util.List<Kucing> kucingListMalaysia = new ArrayList<>();

        Kucing kucingPersia = new Kucing();
        kucingPersia.setJenis("Persian");

        Kucing kucingAngora = new Kucing();
        kucingAngora.setJenis("Angora");

        Kucing kucingKantin = new Kucing();
        kucingKantin.setJenis("Kantin");

        Kucing kucingGarong = new Kucing();
        kucingGarong.setJenis("Garong");

        kucingList.add(0, kucingAngora);
        kucingList.add(1, kucingPersia);
        kucingList.add(2, kucingKantin);
        kucingList.add(3, kucingGarong);

        kucingListMalaysia.add(kucingKantin);
        kucingListMalaysia.add(kucingGarong);

        kucingList.addAll(kucingListMalaysia);

        for(int i = 0; i < kucingList.size() ; i++){
            if(i == 4) {
                break;
            } else {
                System.out.println("ini jenis kucing pengulangan java.util.List not breaked " + kucingList.get(i).getJenis());
            }
        }

        System.out.println("ini jenis kucing java.util.List direct "+kucingList.get(0).getJenis());

        System.out.println("ini length/size java.util.List "+kucingList.size());

    }
}