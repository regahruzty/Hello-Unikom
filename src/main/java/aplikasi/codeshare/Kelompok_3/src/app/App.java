/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.Kelompok_3.src.app;

import java.sql.*;
import main.java.aplikasi.codeshare.Kelompok_3.src.app.Class_.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Centry
 */
public class App {


    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kelompok3";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        //Connection conn = null;
        Statement stmt = null;
        
        Conection con =  new Conection();
        java.sql.Connection conect = con.connectDB();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conect = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conect.createStatement();
            String sql;
            sql = "SELECT t.nama AS nama_tentara, t.pangkat AS pangkat, t.matra AS Matra,\n" +
                  " o.nama_obat AS nama_obat, o.dosis AS dosis, o.Keterangan AS keterangan,\n" +
                  " s.merk AS merk, s.type AS tipe, s.ram AS ram, s.camera AS camera,\n" +
                  " a.nama AS nama_anjing, a.jenis AS jenis_anjing, a.kebiasaan AS kebiasaan_anjing \n" +
                  "\n" +
                  "FROM narasi n JOIN obat o ON n.id_obat = o.id_obat\n" +
                  "		JOIN smartphone s ON n.id_smartphone = s.smartphone_id\n" +
                  "		JOIN tentara t ON n.id_tentara = t.id_tentara\n" +
                  "		JOIN anjing a ON n.id_anjing = a.id_anjing;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            ArrayList<String> ar = new ArrayList<>();
            Smartphone s = new Smartphone();
            Obat o =  new Obat();
            Anjing a = new Anjing();
            Tentara t = new Tentara();
            String temp =  "";        
            while(rs.next()){
                    t.setNama(rs.getString("nama_tentara"));
                    t.setMatra(rs.getString("Matra"));
                    t.setPangkat(rs.getString("pangkat"));
                    
                    o.setNama_obat(rs.getString("nama_obat"));
                    o.setDosis_obat(rs.getString("dosis"));
                    o.setKeterangan_obat(rs.getString("keterangan"));
                    
                    s.setMerk(rs.getString("merk"));
                    s.setCamera(rs.getInt("camera"));
                    s.setRam(rs.getInt("ram"));
                    s.setType(rs.getString("tipe"));
                    
                    a.setNama(rs.getString("nama_anjing"));
                    a.setJenis(rs.getString("jenis_anjing"));
                    a.setKebiasaan(rs.getString("kebiasaan_anjing"));
                    
                
                    temp = temp + " Ada Tentara Beranama "+ t.getNama();
                    temp = temp + " Berpangkat "+ t.getPangkat();
                    temp = temp + " Bermatra : "+ t.getMatra();
                    
                    temp = temp + " Punya Nama Anjing "+ a.getNama();
                    temp = temp + " dengan Jenis "+ a.getJenis();
                    temp = temp + " yang kebiasaannya : "+ a.getKebiasaan();
                    
                    temp = temp + " Meminum obat "+ o.getNama_obat();
                    temp = temp + " Sebanyak "+ o.getDosis_obat();
                    temp = temp + " Untuk "+ o.getKeterangan_obat();
                    
                    temp = temp + " unutk Membeli "+ s.getMerk();
                    temp = temp + " dengan tipe "+ s.getType();
                    temp = temp + " kameranya "+ s.getCamera();
                    temp = temp + " dan ram "+ s.getRam();
                    
                    
                    
                    ar.add(temp);
                    
                    temp = "";
                
            }
            
            
            for (int i = 0; i < ar.size(); i++) {
                System.out.println(ar.get(i));
            }
        } catch (SQLException e) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
    }
    
}
