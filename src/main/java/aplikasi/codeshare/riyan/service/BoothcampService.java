package main.java.aplikasi.codeshare.riyan.service;

import main.java.aplikasi.codeshare.riyan.model.Boothcamp;
import main.java.aplikasi.codeshare.riyan.repository.BoothcampRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BoothcampService implements BoothcampRepository {

    private DataSource dataSource;

    public BoothcampService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Boothcamp save(Boothcamp boothcamp) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into boothcamp (nama_boothcamp, lokasi, alamat) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, boothcamp.getNama_boothcamp());
        preparedStatement.setString(2, boothcamp.getLokasi());
        preparedStatement.setString(3, boothcamp.getAlamat());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        boothcamp.setId_boothcamp(generatedId);

        return boothcamp;
    }

    @Override
    public Boothcamp update(Boothcamp value) throws SQLException {
        return null;
    }

    @Override
    public List<Boothcamp> findALL() throws SQLException {
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
