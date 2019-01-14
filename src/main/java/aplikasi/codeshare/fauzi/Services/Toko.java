/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Services;

/**
 *
 * @author acer
 */
public class Toko {
    private String name;
    private String province;
    private String phone;
    public Toko(){
        
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
}
