package main.java.aplikasi.codeshare.riyan.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * @author dimmaryanto
 */

public class KoneksiDB {
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("");
        ds.setUrl("jdbc:mysql://localhost/belajar_jdbc");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }
}
