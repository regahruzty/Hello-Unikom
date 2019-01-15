package main.java.aplikasi.codeshare.puspa.FinalProject.service;

import main.java.aplikasi.codeshare.puspa.FinalProject.model.Fire;
import main.java.aplikasi.codeshare.puspa.FinalProject.repository.FireRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FireService implements FireRepository {

    private DataSource dataSource;

    public FireService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Fire save(Fire fire) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into fire (nama_fire) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, fire.getNamaFire());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        fire.setIdFire(generatedId);
       // getGeneratedKeys.close();
       // preparedStatement.close();

        return fire;
    }

    @Override
    public Fire update(Fire fire) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update fire set nama_fire = ? where id_fire = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fire.getNamaFire());
        preparedStatement.setLong(2, fire.getIdFire());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return fire;
    }

    @Override
    public List<Fire> findAll() throws SQLException {
        List<Fire> fires = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from fire";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Fire fire = new Fire();
            fire.setIdFire(resultSet.getLong("id_fire"));
            fire.setNamaFire(resultSet.getString("nama_fire"));
            fires.add(fire);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return fires;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from fire where id_fire = ?";

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

        String sql = "delete from fire where id_fire = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }
}