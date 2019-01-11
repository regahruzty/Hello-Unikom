/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fajar;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Centry
 */
public class Main {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/obat";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "Select o.nama_obat AS nama, jo.jenis AS jenis, jo.kategori AS kategori, d.dosis_harian AS dosis_harian, d.dosis_obat AS dosis_obat"
                    + " from obat o join jenis_obat jo "
                    + " on o.id_jenis = jo.id_jenis join dosis d"
                    + " on o.id_dosis = d.id_dosis";
            ResultSet rs = stmt.executeQuery(sql);

            ArrayList<String> ar = new ArrayList<>();
            Class_Dosis ds = new Class_Dosis();
            Class_Obat o =  new Class_Obat();
            Class_Jenis j = new Class_Jenis();
            String temp =  "";        
            while(rs.next()){
                o.setNama_obat(rs.getString("nama"));
                j.setJenis(rs.getString("Jenis"));
                j.setKategori(rs.getString("kategori"));
                ds.setDosis_harian(rs.getString("dosis_harian"));
                ds.setDosis_obat(rs.getString("dosis_obat"));
                
                
                
                temp = temp + " / Nama Obat : "+ o.getNama_obat();
                temp = temp + " / Jenis : "+ j.getJenis();
                temp = temp + " / Kategori : "+ j.getKategori();
                temp = temp + " / Dosis Harian : "+ ds.getDosis_harian();
                temp = temp + " / Obat Obat : "+ ds.getDosis_obat();
                
                ar.add(temp);
                temp = "";

            }
            for (int i = 0; i < ar.size(); i++) {
                System.out.println(ar.get(i));
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
