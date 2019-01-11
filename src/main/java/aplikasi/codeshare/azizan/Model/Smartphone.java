package main.java.aplikasi.codeshare.azizan.Model;

public class Smartphone {
    private String merk;
    private String type;
    private Integer ram;
    private Integer camera;

    public Smartphone(String merk, String type, Integer ram, Integer camera){
        this.merk = merk;
        this.type = type;
        this.ram = ram;
        this.camera = camera;
    }

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