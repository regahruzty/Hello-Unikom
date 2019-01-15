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
public class Smartphone extends Model{
    private String merk = null;
    private String type = null;
    private Integer ram = null;
    private Integer camera = null;
    private int id;
    
    protected String tableName = "smartphone";

    public Smartphone(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Smartphone{" + "merk=" + merk + ", type=" + type + ", ram=" + ram + ", camera=" + camera + ", id=" + id + '}';
    }

//    public Smartphone insert(){
//        try{
//            conn = ds.getConnection();
//            stmt = conn.createStatement();
//            sql = "insert into "+this.getClass().getSimpleName().toLowerCase()+" ("
//                    + "merk, "
//                    + "type, "
//                    + "ram, "
//                    + "camera) "
//                    + "values ('"
//                    + merk +"', '"
//                    + type + "', '"
//                    + ram +"', '"
//                    + camera+"');";
//            System.out.println(sql);
//            
//            stmt.execute(sql);
//            System.out.println("success to save Smartphone");
//        }catch(SQLException se){
//            System.out.println("failed to save Smartphone");
//            se.printStackTrace();
//        }
//        return this;
//    }
    
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
    
//    public List<String> all(){
//        List<String> data = new ArrayList<>();
//        try{
//            
//        conn = ds.getConnection();
//        stmt = conn.createStatement();
//        sql = "select * from "+this.getClass().getSimpleName().toLowerCase()+"";
//        System.out.println(sql);
//
//        ResultSet rs = stmt.executeQuery(sql);
//        
//        while(rs.next()){
//            
//            this.setMerk(rs.getString("merk"));
//            this.setType(rs.getString("type"));
//            this.setRam(Integer.parseInt(rs.getString("ram")));
//            this.setCamera(Integer.parseInt(rs.getString("camera")));
//        }
//        }catch(SQLException se){
//            System.out.println("Failed to get Data"+this.getClass().getSimpleName());
//            se.printStackTrace();
//        }
//        return data;
//    }
//    
    
}

