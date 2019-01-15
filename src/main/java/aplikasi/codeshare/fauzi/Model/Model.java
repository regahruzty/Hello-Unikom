/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import main.java.aplikasi.codeshare.fauzi.config.KoneksiDB;

/**
 *
 * @author acer
 */
public class Model {
    protected DataSource ds = KoneksiDB.getDataSource();
    protected Connection conn = null;
    protected Statement stmt = null;
    protected String sql = null;
    
    public Model delete(int id){
        try{
            conn = ds.getConnection();
            stmt = conn.createStatement();
            sql = "delete from "+this.getClass().getSimpleName().toLowerCase()+" where id='"+id+"'";
            System.out.println(sql);
            
            stmt.execute(sql);
            System.out.println("success to delete "+this.getClass().getSimpleName().toLowerCase()+" where id = "+id);
        }catch(SQLException se){
            System.out.println("failed to delete "+this.getClass().getSimpleName().toLowerCase()+"");
            se.printStackTrace();
        }
        return this;
    }
    
    public List<String> all(){
        List<String> data = new ArrayList<>();
        return data;
    }
}
