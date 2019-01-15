package main.java.aplikasi.codeshare.ariya.ariya_final.service;

import main.java.aplikasi.codeshare.ariya.ariya_final.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.ariya_final.repository.PembeliRepository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class PembeliService implements PembeliRepository {

    private DataSource dataSource;

    public PembeliService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Pembeli save(Pembeli pembeli) throws SQLException {
        Connection connection = dataSource.getConnection();
        
        Long generatedId = null;
        
        String sql="insert into pembeli (nama_pembeli, alamat_pembeli) values (?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        
        preparedStatement.setString(1, pembeli.getNama_pembeli());
        preparedStatement.setString(2, pembeli.getAlamat_pembeli());
        
        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }
        
        pembeli.setId_pembeli(generatedId);
        
        return pembeli;
    }

    @Override
    public Pembeli update(Pembeli value) throws SQLException {
        return null;
    }

    @Override
    public List<Pembeli> findAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
