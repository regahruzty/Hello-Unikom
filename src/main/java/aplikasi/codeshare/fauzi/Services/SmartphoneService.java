/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Services;

import java.sql.SQLException;
import java.util.List;
import main.java.aplikasi.codeshare.fauzi.Model.Smartphone;
import main.java.aplikasi.codeshare.fauzi.repository.SmartphoneRepository;

/**
 *
 * @author acer
 */
public class SmartphoneService implements SmartphoneRepository{

    public SmartphoneService() {
    }

    @Override
    public Smartphone save(Smartphone value) throws SQLException {
        return value.insert();
    }

    @Override
    public Smartphone update(Smartphone value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Smartphone> findAll() throws SQLException {
        Smartphone smart = new Smartphone();
        return smart.all();
    }

    @Override
    public Smartphone findOne(Integer id) throws SQLException {
        Smartphone smart = new Smartphone();
        
//        smart.find(id);
        return smart;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Smartphone smart = new Smartphone();
        
        smart.delete(id);
    }
    
    
}
