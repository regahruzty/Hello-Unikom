        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;

/**
 *
 * @author acer
 */
public class Smartphone extends Model{
    private String merk = null;
    private String type = null;
    private Integer ram = null;
    private Integer camera = null;
    
    
    public Smartphone(DataSource ds){
        this.ds = ds;
    }
    
    public void setMerk(String merk){
        this.merk = merk;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public void setRam(Integer ram){
        this.ram = ram;
    }
    
    
    public void setCamera(Integer camera){
        this.camera = camera;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public String getType(){
        return type;
    }
    public Integer getRam(){
        return ram;
    }
    public Integer getCamera(){
        return camera;
    }
    
    public Smartphone insert(){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "insert into "+this.getClass().getSimpleName().toLowerCase()+" ("
                    + "merk, "
                    + "type, "
                    + "ram, "
                    + "camera) "
                    + "values ('"
                    + merk +"', '"
                    + type + "', '"
                    + ram +"', '"
                    + camera+"');";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to save Smartphone");
        }catch(SQLException se){
            System.out.println("failed to save Smartphone");
            se.printStackTrace();
        }
        return this;
    }
    
    public Smartphone update(int id){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "update "+this.getClass().getSimpleName().toLowerCase()+" set "
                    + "merk ='"+merk
                    + "',type = '"+type
                    + "',ram ='"+ram
                    + "',camera ='"+camera
                    +"' where id='"+id+"'";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to update Smartphone");
        }catch(SQLException se){
            System.out.println("failed to save Smartphone");
            se.printStackTrace();
        }
        return this;
    }
    
    
}

