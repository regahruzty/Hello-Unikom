package main.java.aplikasi.codeshare.azizan.TNI.Service;

import main.java.aplikasi.codeshare.azizan.TNI.Model.Batalyon;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.BatalyonRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BatalyonService implements BatalyonRepository {

    private DataSource dataSource;

    public BatalyonService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Batalyon save(Batalyon batalyon) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql = "INSERT INTO batalyon(nama_batalyon) " +
                "VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, batalyon.getNamaBatalyon());
        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        batalyon.setIdBayalyon(generatedId);

        return batalyon;
    }

    @Override
    public Batalyon update(Batalyon value) throws SQLException {
        return null;
    }

    @Override
    public List<Batalyon> findAll() throws SQLException {
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
