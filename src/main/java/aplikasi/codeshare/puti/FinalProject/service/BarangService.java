package main.java.aplikasi.codeshare.puti.FinalProject.service;

import model.Barang;
import repository.BarangRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangService implements BarangRepository {

    private DataSource dataSource;

    public BarangService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Barang save(Barang barang) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql = "insert into barang (nama_barang) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, barang.getNamaBarang());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()) {
            generatedId = getGeneratedKeys.getLong(1);
        }

        barang.setIdBarang(generatedId);

        return barang;
    }

    @Override
    public Barang update(Barang barang) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update barang set nama_barang = ? where id_barang = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, barang.getNamaBarang());
        preparedStatement.setLong(2, barang.getIdBarang());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return barang;

    }

    @Override
    public List<Barang> findAll() throws SQLException {
        List<Barang> barangs = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from barang";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Barang barang = new Barang();
            barang.setIdBarang(resultSet.getLong("id_barang"));
            barang.setNamaBarang(resultSet.getString("nama_barang"));
            barangs.add(barang);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return barangs;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from barang where id_barang = ?";

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

        String sql = "delete from barang where id_barang = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}