package main.java.aplikasi.codeshare.ariya.ariya_final.service;

import main.java.aplikasi.codeshare.ariya.ariya_final.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.ariya_final.repository.PembeliRepository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
    public Pembeli update(Pembeli pembeli) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update pembeli set nama_pembeli = ?, alamat_pembeli = ? where id_pembeli = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pembeli.getNama_pembeli());
        preparedStatement.setString(2, pembeli.getAlamat_pembeli());
        preparedStatement.setLong(3, pembeli.getId_pembeli());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return pembeli;
    }


    @Override
    public List<Pembeli> findAll() throws SQLException {
        List<Pembeli> pembeliList= new ArrayList<>();


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from pembeli";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Pembeli pembeli = new Pembeli();
            pembeli.setId_pembeli(resultSet.getLong("id_pembeli"));
            pembeli.setNama_pembeli(resultSet.getString("nama_pembeli"));
            pembeli.setAlamat_pembeli(resultSet.getString("alamat_pembeli"));
            pembeliList.add(pembeli);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return pembeliList;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from pembeli where id_pembeli = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            count = count + resultSet.getLong(1);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return count > 0;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from pembeli where id_pembeli = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
