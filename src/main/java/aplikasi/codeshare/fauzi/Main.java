/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author acer
 */
public class Main {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/smartphone";
    
    static final String USER = "root";
    static final String PASS = "";
    
    public static void main(String[] args){
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            
            String sql = "select * from smartphones";
            
            ResultSet rs = stmt.executeQuery(sql);
            List<Smartphone> smartList = new ArrayList<>();
            while(rs.next()){
                   
                
                Smartphone smart = new Smartphone();
                smart.setMerk(rs.getString("merk"));
                smart.setType(rs.getString("type"));
                smart.setRam(rs.getInt("ram"));
                smart.setCamera(rs.getInt("camera"));
                
                smartList.add(smart);
            }
            
            for (Smartphone sm : smartList){
                System.out.print("Merk "+sm.getMerk());
                System.out.print(" Ram "+sm.getRam());
                System.out.print(" Camera "+sm.getCamera()+" MP");
                System.out.println(", Type "+sm.getType());
                
            }

        }catch(ClassNotFoundException cnfe){
         
            cnfe.printStackTrace();
        
        }catch(SQLException se){
         
            se.printStackTrace();
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
