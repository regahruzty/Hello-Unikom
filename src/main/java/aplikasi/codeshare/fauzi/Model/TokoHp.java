/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import javax.sql.DataSource;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;

/**
 *
 * @author acer
 */
public class TokoHp extends Model {
    
    public Toko Toko = new Toko();
    public Smartphone Smartphone = new Smartphone(ds);
    
    public TokoHp(){
        
    }
}
