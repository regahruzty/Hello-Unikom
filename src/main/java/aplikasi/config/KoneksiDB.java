/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.config;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * @author dimmaryanto
 */
public class KoneksiDB {

    public static DataSource getDataSourceMysqlLearnJDBC() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("");
        ds.setUrl("jdbc:mysql://localhost:3306/learn_jdbc");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    public static DataSource getDataSourceMariaDBLearnJDBC2() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("root");
        ds.setPassword("");
        ds.setUrl("jdbc:mysql://localhost:3306/learn_jdbc");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }
}