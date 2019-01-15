package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Batalyon;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Repository.BatalyonRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
    public Batalyon update(Batalyon batalyon) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "UPDATE batalyon SET nama_batalyon = ? WHERE id_batalyon = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, batalyon.getNamaBatalyon());
        preparedStatement.setLong(2, batalyon.getIdBayalyon());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return batalyon;
    }

    @Override
    public List<Batalyon> findAll() throws SQLException {
        List<Batalyon> batalyons = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM batalyon";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Batalyon batalyon = new Batalyon();
            batalyon.setIdBayalyon(resultSet.getLong("id_batalyon"));
            batalyon.setNamaBatalyon(resultSet.getString("nama_batalyon"));
            batalyons.add(batalyon);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return batalyons;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "SELECT COUNT(*) FROM batalyon WHERE id_batalyon = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
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

        String sql = "DELETE FROM batalyon WHERE id_batalyon = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
