/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Services;

import java.sql.SQLException;
import java.util.List;
import main.java.aplikasi.codeshare.fauzi.Model.TokoHp;
import main.java.aplikasi.codeshare.fauzi.repository.TokoHpRepository;

/**
 *
 * @author acer
 */
public class TokoHpService implements TokoHpRepository{

    public TokoHpService() {
    }

    @Override
    public TokoHp save(TokoHp value) throws SQLException {
        return value.insert();
    }

    @Override
    public TokoHp update(TokoHp value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TokoHp> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TokoHp findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
