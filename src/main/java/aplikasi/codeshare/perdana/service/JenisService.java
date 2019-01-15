package main.java.aplikasi.codeshare.perdana.service;

import model.Jenis;
import repository.JenisRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisService implements JenisRepository {

    private DataSource dataSource;

    public JenisService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Jenis save(Jenis jenis) throws SQLException {
        Connection connection = dataSource.getConnection();

        Integer generatedId = null;

        String sql="insert into jenis (jenis, keterangan) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, jenis.getJenis());
        preparedStatement.setString(2, jenis.getKeterangan());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        jenis.setId_jenis(generatedId);

        preparedStatement.close();
        connection.close();

        return jenis;
    }

    @Override
    public Jenis update(Jenis jenis) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update jenis set jenis = ? where id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, jenis.getJenis());
        preparedStatement.setInt(2, jenis.getId_jenis());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return jenis;

    }

    @Override
    public List<Jenis> findAll() throws SQLException {
        List<Jenis> jeniss = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from jenis";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Jenis jenis = new Jenis();
            jenis.setId_jenis(resultSet.getInt("id_jenis"));
            jenis.setJenis(resultSet.getString("nama"));
            jenis.setKeterangan(resultSet.getString("merk"));
            jeniss.add(jenis);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return jeniss;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from jenis where id_jenis = ?";

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

        String sql = "delete from jenis where id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
