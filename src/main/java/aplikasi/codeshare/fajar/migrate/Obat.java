/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fajar.migrate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Centry
 */
public class Obat {
    public static void main(String[] args) {
        utils.ClearTable();
        
        utils.CreateTableObat();
        utils.CreateTableDosisObat();
        utils.CreateTableJenisObat();
        utils.CreateTableObatRelation();
        utils.CreateContraintForeighnKey();
    }
}
class utils{//belajar_jdbc
    public static final String DB_URL =  "jdbc:mysql://localhost:3306/belajar_jdbc";
    public static final String USER =  "root";
    public static final String PASSWORD =  "";
    
    public static void CreateTableObat(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS obat";
            st.executeUpdate(cl);
            
            String sql = "CREATE TABLE `obat` (\n" +
                        "  `id_obat` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `nama_obat` varchar(255) DEFAULT NULL,\n" +
                        "  `nama_produsen` varchar(255) DEFAULT NULL,\n" +
                        "  `nama_distributor` varchar(255) DEFAULT NULL,\n" +
                        "  `tangal_kadarluarsa` varchar(255) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id_obat`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;";
            st.executeUpdate(sql);
            System.out.println("ini Connection Pembuatan Table Obat "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed Create Table Obat");
        }
    }
    public static void CreateTableJenisObat(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS jenis_obat;";
            st.executeUpdate(cl);
            
            String sql = "CREATE TABLE `jenis_obat` (\n" +
                        "  `id_jenis` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `jenis` varchar(255) DEFAULT NULL,\n" +
                        "  `kategori` varchar(255) DEFAULT NULL,\n" +   
                        "  `keterangan` text,\n" +
                        "  PRIMARY KEY (`id_jenis`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;";
            st.executeUpdate(sql);
            System.out.println("ini Connection Pembuatan Table Jenis Obat "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed Create TAble jenis Obat");
        }
    }
    public static void CreateTableDosisObat(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS dosis;";
            st.executeUpdate(cl);
            
            String sql = "CREATE TABLE `dosis` (\n" +
                        "  `id_dosis` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `dosis_obat` varchar(255) DEFAULT NULL,\n" +
                        "  `dosis_harian` varchar(255) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id_dosis`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;";
            st.executeUpdate(sql);
            System.out.println("ini Connection Pembuatan Table Dosis Obat "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed CreateTableObat");
        }
    }
    public static void CreateTableObatRelation(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            //Clear table if exists
            String cl = "DROP TABLE IF EXISTS obat_relation;";
            st.executeUpdate(cl);
            
            String sql = "CREATE TABLE `obat_relation` (\n" +
                         "  `id_relasi_obat` int(11) NOT NULL AUTO_INCREMENT,\n" +
                         "  `id_obat` int(11) NOT NULL,\n" +
                         "  `id_jenis` int(11) NOT NULL,\n" +
                         "  `id_dosis` int(11) NOT NULL,\n" +
                         "  PRIMARY KEY (`id_relasi_obat`)\n" +
                         ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
            st.executeUpdate(sql);
            System.out.println("ini Connection Pembuatan Table  relation "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed Create Table Obat Relation");
        }
        
        
    }    
    public static void CreateContraintForeighnKey(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            String sql;
            
            sql = "alter table obat_relation "
                    + " ADD CONSTRAINT fk_table_obat foreign key (id_obat) references obat(id_obat);";
            st.executeUpdate(sql);
            sql = "alter table obat_relation "
                    + " ADD CONSTRAINT fk_table_jenisF foreign key (id_jenis) references jenis_obat(id_jenis);";
            st.executeUpdate(sql);
            sql = "alter table obat_relation "
                    + " ADD CONSTRAINT fk_table_dosisF foreign key (id_dosis) references dosis(id_dosis);";
            st.executeUpdate(sql);
            System.out.println("ini Connection Contraint Foreighn Key "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to Foreign Key");
        }
        }

    public static void ClearTable(){
        Connection con;
        Statement st;
        try {
            con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            st = con.createStatement();
            String sql;
            
            sql = "DROP TABLE IF EXISTS obat_relation";
            st.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS obat ";
            st.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS jenis_obat";
            st.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS dosis";
            st.executeUpdate(sql);
            System.out.println("ini Connection Contraint Foreighn Key "+con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Failed to Foreign Key");
        }
        }
    
}