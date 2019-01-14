        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi;

/**
 *
 * @author acer
 */
public class Smartphone {
    private String merk;
    private String type;
    private Integer ram;
    private Integer camera;
    
    public Smartphone(){
    
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
    
}

//class Xiaoko extends Smartphone{
//    public Xiaoko(){
//        setCamera(24);
//        setMerk("Xiako");
//        setType("A501");
//        setRam(4);
//    }
//}
