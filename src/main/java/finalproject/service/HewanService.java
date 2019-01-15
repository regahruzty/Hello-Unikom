package main.java.finalproject.service;

import main.java.finalproject.model.Hewan;
import main.java.finalproject.repository.HewanRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HewanService implements HewanRepository {

    private DataSource dataSource;

    public HewanService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Hewan save(Hewan hewan) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql = "insert into hewan (nama_hewan) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, hewan.getNamaHewan());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()) {
            generatedId = getGeneratedKeys.getLong(1);
        }

        hewan.setIdHewan(generatedId);

        getGeneratedKeys.close();
        preparedStatement.close();
        connection.close();

        return hewan;
    }

    @Override
    public Hewan update(Hewan hewan) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update hewan set nama_hewan = ? where id_hewan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, hewan.getNamaHewan());
        preparedStatement.setLong(2, hewan.getIdHewan());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return hewan;
    }

    @Override
    public List<Hewan> findAll() throws SQLException {
        List<Hewan> hewans = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from hewan";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Hewan hewan = new Hewan();
            hewan.setIdHewan(resultSet.getLong("id_hewan"));
            hewan.setNamaHewan(resultSet.getString("nama_hewan"));
            hewans.add(hewan);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return hewans;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from hewan where id_hewan = ?";

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

        String sql = "delete from hewan where id_hewan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
