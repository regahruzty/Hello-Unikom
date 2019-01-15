package main.java.aplikasi.codeshare.ariya.ariya_final.service;

import main.java.aplikasi.codeshare.ariya.ariya_final.model.Motor;
import main.java.aplikasi.codeshare.ariya.ariya_final.repository.MotorRepository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotorService implements MotorRepository {

    private DataSource dataSource;

    public MotorService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Motor save(Motor motor) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into motor (nama_motor, merk_motor) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, motor.getNama_motor());
        preparedStatement.setString(2, motor.getMerk_motor());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        motor.setId_motor(generatedId);

        return motor;
    }

    @Override
    public Motor update(Motor motor) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update motor set nama_motor = ?, merk_motor = ? where id_motor = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, motor.getNama_motor());
        preparedStatement.setString(2, motor.getMerk_motor());
        preparedStatement.setLong(3, motor.getId_motor());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return motor;
    }

    @Override
    public List<Motor> findAll() throws SQLException {
        List<Motor> mototList = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from motor";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Motor motor = new Motor();
            motor.setId_motor(resultSet.getLong("id_motor"));
            motor.setNama_motor(resultSet.getString("nama_motor"));
            motor.setMerk_motor(resultSet.getString("merk_motor"));

            mototList.add(motor);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return mototList;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from motor where id_motor = ?";

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

        String sql = "delete from motor where id_motor = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
