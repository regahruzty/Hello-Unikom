package main.java.aplikasi.codeshare.puspa.FinalProject.service;

import main.java.aplikasi.codeshare.puspa.FinalProject.model.Water;
import main.java.aplikasi.codeshare.puspa.FinalProject.repository.WaterRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WaterService implements WaterRepository {
    private DataSource dataSource;

    public WaterService(DataSource dataSource) { this.dataSource = dataSource; }

    @Override
    public Water save(Water water) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into water (nama_water) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, water.getNamaWater());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        water.setIdWater(generatedId);
     //   getGeneratedKeys.close();
     //   preparedStatement.close();

        return water;
    }

    @Override
    public Water update(Water water) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update water set nama_water = ? where id_water = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, water.getNamaWater());
        preparedStatement.setLong(2, water.getIdWater());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return water;
    }

    @Override
    public List<Water> findAll() throws SQLException {
        List<Water> waters = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from water";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Water water = new Water();
            water.setIdWater(resultSet.getLong("id_water"));
            water.setNamaWater(resultSet.getString("nama_water"));
            waters.add(water);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return waters;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from water where id_water = ?";

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

        String sql = "delete from water where id_water = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
