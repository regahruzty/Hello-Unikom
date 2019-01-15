/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.aplikasi.codeshare.fauzi.Services;

import java.sql.SQLException;
import java.util.List;
import main.java.aplikasi.codeshare.fauzi.Model.Toko;
import main.java.aplikasi.codeshare.fauzi.repository.TokoRepository;


/**
 *
 * @author acer
 */
public class TokoService implements TokoRepository{

    @Override
    public Toko save(Toko value) throws SQLException {
        
        return value.insert();
    }

    @Override
    public Toko update(Toko value) throws SQLException {
        return value.update(value);
    }

    @Override
    public List<Toko> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Toko toko = new Toko();
        toko.delete(id);
    }

    @Override
    public Toko findOne(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
