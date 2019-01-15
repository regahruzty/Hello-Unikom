package main.java.aplikasi.codeshare.ariya.ariya_final.service;

import main.java.aplikasi.codeshare.ariya.ariya_final.model.Motor;
import main.java.aplikasi.codeshare.ariya.ariya_final.repository.MotorRepository;


import javax.sql.DataSource;
import java.sql.*;
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
    public Motor update(Motor value) throws SQLException {
        return null;
    }

    @Override
    public List<Motor> findAll() throws SQLException {
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
