package main.java.aplikasi.codeshare.perdana.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class KoneksiDB {

    public static DataSource getKoneksi(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/mobil_perdana");
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");

        return basicDataSource;
    }
}
