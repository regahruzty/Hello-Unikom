/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi;

import main.java.aplikasi.codeshare.fauzi.Model.Smartphone;
import main.java.aplikasi.codeshare.fauzi.Model.TokoHp;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;
/**
 *
 * @author acer
 */
public class Main {
    
    public static void main(String[] args){
        
        TokoHp toko_hp = new TokoHp();
// <<<<<<<<<<< Input Data HP        
        toko_hp.Smartphone.setMerk("asdad");
        toko_hp.Smartphone.setType("Lumiaasdas F");
        toko_hp.Smartphone.setRam(3);
        toko_hp.Smartphone.setCamera(4);
        Smartphone st = toko_hp.Smartphone.update(7);
        System.out.println(st.getMerk());
//        toko_hp.Smartphone.setMerk("Nokia 1 ");
//        toko_hp.Smartphone.setType("Lumia FX1 ");
//        toko_hp.Smartphone.setRam(2);
//        toko_hp.Smartphone.setCamera(2);
//        toko_hp.Smartphone.insert();
//    
//        toko_hp.Smartphone.setMerk("Nokia");
//        toko_hp.Smartphone.setType("Lumia Mi ");
//        toko_hp.Smartphone.setRam(2);
//        toko_hp.Smartphone.setCamera(1);
//        toko_hp.Smartphone.insert();
// >>>>>>>>

// <<<<<<<<<<< delete Smartphone extends Class MODEL
//          toko_hp.Smartphone.delete(3);
// >>>>>>>>>>>>>>
    }
}
