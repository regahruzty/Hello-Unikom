/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static main.java.aplikasi.codeshare.fauzi.Model.Model.sql;

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
    
    public Toko insert() throws SQLException{
        
        int generatedId =0;
        sql = "insert into toko(name,province,phone)"
                + "values(?,?,?)";
        conn = ds.getConnection();
        ps = conn.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);


        ps.setString(1, this.getName());
        ps.setString(2, this.getProvince());
        ps.setString(3, this.getPhone());

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
    
    public Toko update(Toko toko){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "update "+this.getClass().getSimpleName().toLowerCase()+" set "
                    + "name ='"+toko.getName()
                    + "',province = '"+toko.getProvince()
                    + "',phone ='"+toko.getPhone()
                    +"' where id='"+toko.getId()+"'";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to update Toko");
        }catch(SQLException se){
            System.out.println("failed to save Toko");
            se.printStackTrace();
        }
        return this;
    }
    
    public List<Toko> all() throws SQLException{
        List<Toko> tokos = new ArrayList<>();

        conn = ds.getConnection();
        stmt = conn.createStatement();

        String sql = "select * from toko";

        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            Toko toko = new Toko();
            toko.setId(resultSet.getInt("id"));
            toko.setName(resultSet.getString("name"));
            toko.setProvince(resultSet.getString("province"));
            toko.setPhone(resultSet.getString("phone"));
            tokos.add(toko);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return tokos;
    }

    @Override
    public String toString() {
        return "Toko{" + "name=" + name + ", id=" + id + ", province=" + province + ", phone=" + phone + '}';
    }
    
    
}
