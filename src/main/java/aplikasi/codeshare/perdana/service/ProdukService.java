package main.java.aplikasi.codeshare.perdana.service;

import main.java.aplikasi.codeshare.perdana.model.Produk;
import main.java.aplikasi.codeshare.perdana.repository.ProdukRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdukService implements ProdukRepository {

    private DataSource dataSource;

    public ProdukService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Produk save(Produk produk) throws SQLException {
        Connection connection = dataSource.getConnection();

        Integer generatedId = null;

        String sql="insert into produk (nama, merk, waktu_pembuatan) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, produk.getNama());
        preparedStatement.setString(2, produk.getMerk());
        preparedStatement.setString(3, produk.getWaktu_pembuatan());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        produk.setId_produk(generatedId);

        preparedStatement.close();
        connection.close();

        return produk;
    }

    @Override
    public Produk update(Produk produk) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update produk set nama = ? where id_produk = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, produk.getNama());
        preparedStatement.setInt(2, produk.getId_produk());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return produk;

    }

    @Override
    public List<Produk> findAll() throws SQLException {
        List<Produk> produks = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from produk";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produk produk = new Produk();
            produk.setId_produk(resultSet.getInt("id_produk"));
            produk.setNama(resultSet.getString("nama"));
            produk.setMerk(resultSet.getString("merk"));
            produk.setWaktu_pembuatan(resultSet.getString("waktu_pembuatan"));
            produks.add(produk);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return produks;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from produk where id_produk = ?";

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

        String sql = "delete from produk where id_produk = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
