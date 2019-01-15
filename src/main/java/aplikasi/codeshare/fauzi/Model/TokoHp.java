/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.SQLException;
import javax.sql.DataSource;
import static main.java.aplikasi.codeshare.fauzi.Model.Model.conn;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;

/**
 *
 * @author acer
 */
public class TokoHp extends Model {
    
    public Toko Toko = new Toko();
    public Smartphone Smartphone = new Smartphone();
    private int id;
    
    public TokoHp(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Toko getToko() {
        return Toko;
    }

    public void setToko(Toko Toko) {
        this.Toko = Toko;
    }

    public Smartphone getSmartphone() {
        return Smartphone;
    }

    public void setSmartphone(Smartphone Smartphone) {
        this.Smartphone = Smartphone;
    }

    @Override
    public String toString() {
        return "TokoHp{" + "Toko=" + Toko + ", Smartphone=" + Smartphone + ", id=" + id + '}';
    }

   
    
    public TokoHp insert(){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "insert into "+this.getClass().getSimpleName().toLowerCase()+" ("
                    + "toko_id, "
                    + "smartphone_id) "
                    + "values ('"
                    + this.Toko.getId() +"', '"
                    + this.Smartphone.getId() +"');";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to save Toko");
        }catch(SQLException se){
            System.out.println("failed to save Toko");
            se.printStackTrace();
        }
        return this;
    }
}
