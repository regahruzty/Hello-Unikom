        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    protected String table = "smartphone";

    
    
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
        return "Smartphone{" + "merk=" + merk + ", type=" + type + ", ram=" + ram + ", camera=" + camera + ", id=" + id + "}\n";
    }

    public Smartphone insert() throws SQLException{
        
        int generatedId =0;
        sql = "insert into smartphone(merk,type,ram,camera)"
                + "values(?,?,?,?)";
        conn = ds.getConnection();
        ps = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);


        ps.setString(1, this.getMerk());
        ps.setString(2, this.getType());
        ps.setInt(3, this.getRam());
        ps.setInt(4, this.getCamera());

        ps.executeUpdate();

        ResultSet getGeneratedKeys = ps.getGeneratedKeys();
        while (getGeneratedKeys.next()) {
            generatedId = getGeneratedKeys.getInt(1);
        }

        id = generatedId;

        getGeneratedKeys.close();
        ps.close();
        conn.close();
        
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
    
    public List<Smartphone> all() throws SQLException{
        List<Smartphone> smartphones = new ArrayList<>();
        conn = ds.getConnection();
        stmt = conn.createStatement();

        String sql = "select * from smartphone";

        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            Smartphone smart = new Smartphone();
            smart.setId(resultSet.getInt("id"));
            smart.setMerk(resultSet.getString("merk"));
            smart.setRam(Integer.parseInt(resultSet.getString("ram")));
            smart.setCamera(Integer.parseInt(resultSet.getString("camera")));
            smartphones.add(smart);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return smartphones;
    }
//    
    
}

