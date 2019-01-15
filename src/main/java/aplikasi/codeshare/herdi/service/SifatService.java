package main.java.aplikasi.codeshare.herdi.service;

import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.model.Sifat;
import main.java.aplikasi.codeshare.herdi.repository.BurungRepository;
import main.java.aplikasi.codeshare.herdi.repository.SifatRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SifatService implements SifatRepository {

    private DataSource dataSource;

    public SifatService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Sifat save(Sifat sifat) throws SQLException {
        Connection connection = dataSource.getConnection();

        Integer generatedId = 0;

        String sql = "INSERT INTO sifat (sifat,desc_sifat) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,sifat.getSifat());
        preparedStatement.setString(2,sifat.getDesc_sifat());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();

        while(getGeneratedKeys.next()){
            generatedId= ((Long) getGeneratedKeys.getLong(1)).intValue();
        }

        sifat.setId_sifat(generatedId);

        return sifat;
    }

    @Override
    public Sifat update(Sifat sifat) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "UPDATE sifat set sifat = ?, desc_sifat = ? where id_sifat = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, sifat.getSifat());
        preparedStatement.setString(2, sifat.getDesc_sifat());
        preparedStatement.setInt(2, sifat.getId_sifat());

        preparedStatement.executeUpdate(sql);

        preparedStatement.close();
        connection.close();

        return sifat;
    }

    @Override
    public List<Sifat> findAll() throws SQLException {

        List<Sifat> sifatList = new ArrayList<>();


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM sifat";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            //jenis
            Sifat sifat = new Sifat();

            sifat.setId_sifat(resultSet.getInt("id_sifat"));
            sifat.setSifat(resultSet.getString("sifat"));
            sifat.setDesc_sifat(resultSet.getString("desc_sifat"));

            sifatList.add(sifat);

        }

        resultSet.close();
        statement.close();
        connection.close();

        return sifatList;

    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from sifat where id_sifat = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            count = count + resultSet.getLong(1);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return count > 0 ? true : false;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from sifat where id_sifat = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
