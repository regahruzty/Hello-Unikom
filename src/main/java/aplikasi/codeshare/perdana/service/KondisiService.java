package main.java.aplikasi.codeshare.perdana.service;

import main.java.aplikasi.codeshare.perdana.model.Kondisi;
import main.java.aplikasi.codeshare.perdana.repository.KondisiRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KondisiService implements KondisiRepository {

    private DataSource dataSource;

    public KondisiService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Kondisi save(Kondisi kondisi) throws SQLException {
        Connection connection = dataSource.getConnection();

        Integer generatedId = null;

        String sql="insert into kondisi (body, mesin, create_date) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, kondisi.getBody());
        preparedStatement.setString(2, kondisi.getMesin());
        preparedStatement.setString(3, kondisi.getCreate_date());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        kondisi.setId_kondisi(generatedId);

        preparedStatement.close();
        connection.close();

        return kondisi;
    }

    @Override
    public Kondisi update(Kondisi kondisi) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update kondisi set body = ? where id_kondisi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, kondisi.getBody());
        preparedStatement.setInt(2, kondisi.getId_kondisi());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return kondisi;

    }

    @Override
    public List<Kondisi> findAll() throws SQLException {
        List<Kondisi> kondisis = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from kondisi";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Kondisi kondisi = new Kondisi();
            kondisi.setId_kondisi(resultSet.getInt("id_kondisi"));
            kondisi.setBody(resultSet.getString("body"));
            kondisi.setMesin(resultSet.getString("mesin"));
            kondisi.setCreate_date(resultSet.getString("create_date"));
            kondisis.add(kondisi);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return kondisis;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from kondisi where id_kondisi = ?";

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
    public void delete(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from kondisi where id_kondisi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
