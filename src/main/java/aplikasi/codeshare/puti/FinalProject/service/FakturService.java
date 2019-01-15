package main.java.aplikasi.codeshare.puti.FinalProject.service;

import model.Barang;
import model.Faktur;
import model.Pembeli;
import repository.FakturRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FakturService implements FakturRepository {
    private DataSource dataSource;

    public FakturService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Faktur save(Faktur faktur) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into faktur (id_barang, id_pembeli) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, faktur.getBarang().getIdBarang());
        preparedStatement.setLong(2, faktur.getPembeli().getIdPembeli());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        faktur.setIdFaktur(generatedId);

        return faktur;
    }

    @Override
    public Faktur update(Faktur faktur) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update faktur set id_barang = ?, id_pembeli = ? where id_faktur = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, faktur.getBarang().getIdBarang());
        preparedStatement.setLong(2, faktur.getPembeli().getIdPembeli());
        preparedStatement.setLong(2, faktur.getIdFaktur());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return faktur;
    }

    @Override
    public List<Faktur> findAll() throws SQLException {
        List<Faktur> fakturs = new ArrayList<>();
        Faktur faktur = new Faktur();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select fak.id_faktur as id_faktur, brg.id_barang as id_barang, brg.nama_barang as nama_barang, pem.id_pembeli as id_pembeli, pem.nama_pembeli as nama_pembeli from faktur fak join barang brg on fak.id_barang = brg.id_barang join pembeli pem on fak.id_pembeli = pem.id_pembeli ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            faktur.setIdFaktur(resultSet.getLong("id_faktur"));

            Barang barang = new Barang();
            barang.setIdBarang(resultSet.getLong("id_barang"));
            barang.setNamaBarang(resultSet.getString("nama_barang"));

            faktur.setBarang(barang);

            Pembeli pembeli = new Pembeli();
            pembeli.setIdPembeli(resultSet.getLong("id_pembeli"));
            pembeli.setNamaPembeli(resultSet.getString("nama_pembeli"));

            faktur.setPembeli(pembeli);

            fakturs.add(faktur);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return fakturs;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from faktur where id_ekosistem = ?";

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

        String sql = "delete from faktur where id_faktur = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteByIdBarangAndIdPembeli(Long idBarang, Long idPembeli) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from faktur where id_barang = ? and id_pembeli = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, idBarang);
        preparedStatement.setLong(2, idPembeli);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }
    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE barang (" +
                " id_barang bigint not null primary key auto_increment, " +
                " nama_barang varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE pembeli (" +
                " id_pembeli bigint not null primary key auto_increment, " +
                " nama_pembeli varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE faktur (" +
                " id_faktur bigint not null primary key auto_increment, " +
                " id_barang bigint not null, " +
                " id_pembeli bigint not null )";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE faktur add constraint fk_faktur_barang " +
                " foreign key (id_barang) references barang (id_barang) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE faktur add constraint fk_faktur_pembeli " +
                " foreign key (id_pembeli) references pembeli (id_pembeli) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
