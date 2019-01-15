package main.java.aplikasi.codeshare.herdi.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class KoneksiDB {

    public static DataSource getKoneksi(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/belajar_jdbc");
        basicDataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        return  basicDataSource;
    }
}
