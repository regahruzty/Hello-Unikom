package main.java.finalproject.service;

import main.java.finalproject.model.Tumbuhan;
import main.java.finalproject.repository.TumbuhanRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TumbuhanService implements TumbuhanRepository {

    private DataSource dataSource;

    public TumbuhanService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Tumbuhan save(Tumbuhan tumbuhan) throws SQLException {
        Connection connection = dataSource.getConnection();
        
        Long generatedId = null;
        
        String sql="insert into tumbuhan (nama_tumbuhan) values (?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        
        preparedStatement.setString(1, tumbuhan.getNamaTumbuhan());
        
        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }
        
        tumbuhan.setIdTumbuhan(generatedId);
        
        return tumbuhan;
    }

    @Override
    public Tumbuhan update(Tumbuhan tumbuhan) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update tumbuhan set nama_tumbuhan = ? where id_tumbuhan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tumbuhan.getNamaTumbuhan());
        preparedStatement.setLong(2, tumbuhan.getIdTumbuhan());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return tumbuhan;
    }

    @Override
    public List<Tumbuhan> findAll() throws SQLException {
        List<Tumbuhan> tumbuhans = new ArrayList<>();
        Tumbuhan tumbuhan = new Tumbuhan();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from tumbuhan";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            tumbuhan.setIdTumbuhan(resultSet.getLong("id_tumbuhan"));
            tumbuhan.setNamaTumbuhan(resultSet.getString("nama_tumbuhan"));
            tumbuhans.add(tumbuhan);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return tumbuhans;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from tumbuhan where id_tumbuhan = ?";

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

        String sql = "delete from tumbuhan where id_tumbuhan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
