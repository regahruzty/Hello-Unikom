/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class Toko extends Model{
    private String name;
    private int id;
    private String province;
    private String phone;
    public Toko(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getPhone(){
        return phone;
    }
    public void setProvince(String province){
        this.province = province;
    }
    
    public String getProvince(){
        return province;
    }
    
    public Toko insert(){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "insert into "+this.getClass().getSimpleName().toLowerCase()+" ("
                    + "name, "
                    + "province, "
                    + "phone) "
                    + "values ('"
                    + name +"', '"
                    + province + "', '"
                    + phone+"');";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to save Toko");
        }catch(SQLException se){
            System.out.println("failed to save Toko");
            se.printStackTrace();
        }
        return this;
    }
    
    public Toko update(int id){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "update "+this.getClass().getSimpleName().toLowerCase()+" set "
                    + "name ='"+name
                    + "',province = '"+province
                    + "',phone ='"+phone
                    +"' where id='"+id+"'";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to update Toko");
        }catch(SQLException se){
            System.out.println("failed to save Toko");
            se.printStackTrace();
        }
        return this;
    }

    @Override
    public String toString() {
        return "Toko{" + "name=" + name + ", id=" + id + ", province=" + province + ", phone=" + phone + '}';
    }
    
    
}
