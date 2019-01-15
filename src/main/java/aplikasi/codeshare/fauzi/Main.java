/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi;

import java.sql.SQLException;
import main.java.aplikasi.codeshare.fauzi.Model.TokoHp;
import main.java.aplikasi.codeshare.fauzi.Services.SmartphoneService;
import main.java.aplikasi.codeshare.fauzi.Services.TokoHpService;
import main.java.aplikasi.codeshare.fauzi.Services.TokoService;
/**
 *
 * @author acer
 */
public class Main {
    
    public static void main(String[] args) throws SQLException{
        SmartphoneService smartSer = new SmartphoneService();
        TokoService tokoSer = new TokoService();
        TokoHpService tokoHpSer = new TokoHpService();
        TokoHp toko_hp = new TokoHp();
        
// <<<<<<<<<<< Input Data HP        
//        toko_hp.Smartphone.setMerk("asdad");
//        toko_hp.Smartphone.setType("Lumiaasdas 2 F");
//        toko_hp.Smartphone.setRam(3);
//        toko_hp.Smartphone.setCamera(4);
//        smartSer.save(toko_hp.Smartphone);
//        
//        toko_hp.Toko.setName("T1oko Abadi");
//        toko_hp.Toko.setPhone("08323123");
//        toko_hp.Toko.setProvince("Jakarta");
//        tokoSer.save(toko_hp.Toko);
//        
//        toko_hp.setSmartphone(toko_hp.Smartphone);
//        toko_hp.setToko(toko_hp.Toko);
//        tokoHpSer.save(toko_hp);
//        
//        System.out.println(toko_hp.toString());
//        
//        System.out.print(smartSer.findAll());
//        
//        
//        System.out.print(tokoHpSer.findAll());
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
          toko_hp.Smartphone.delete(8);
// >>>>>>>>>>>>>>

//// <<<<< update
//        toko_hp.Smartphone.setMerk("as1231231d");
//        toko_hp.Smartphone.setType("Lumiaasdas F");
//        toko_hp.Smartphone.setRam(3);
//        toko_hp.Smartphone.setCamera(4);
//        toko_hp.Smartphone.update(8);
// >>>>>>>>>>>>>>
          
    }
}
