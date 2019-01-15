package main.java.aplikasi.codeshare.perdana.service;

import model.Jenis;
import model.Joined_ID;
import model.Kondisi;
import model.Produk;
import repository.Joined_IDRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Joined_IDService implements Joined_IDRepository {

    private DataSource dataSource;

    public Joined_IDService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Joined_ID save(Joined_ID joined_id) throws SQLException {
        Connection connection = dataSource.getConnection();

        Integer generatedId = null;

        String sql="insert into joined_id_perdana (id_produk, id_jenis, id_kondisi) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, joined_id.getProduk().getId_produk());
        preparedStatement.setInt(2, joined_id.getJenis().getId_jenis());
        preparedStatement.setInt(3, joined_id.getKondisi().getId_kondisi());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        joined_id.setId_joined_id(generatedId);

        preparedStatement.close();
        connection.close();

        return joined_id;
    }

    @Override
    public Joined_ID update(Joined_ID joined_id) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update joined_id_perdana set id_produk = ? where id_joined_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, joined_id.getProduk().getId_produk());
        preparedStatement.setInt(2, joined_id.getId_joined_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return joined_id;

    }

    @Override
    public List<Joined_ID> findAll() throws SQLException {
        List<Joined_ID> joined_ids = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from joined_id";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Joined_ID joined_id = new Joined_ID();
            Produk produk = new Produk();
            produk.setNama(resultSet.getString("nama"));
            produk.setMerk(resultSet.getString("merk"));
            produk.setWaktu_pembuatan(resultSet.getString("waktu_pembuatan"));

            joined_id.setProduk(produk);

            Jenis jenis = new Jenis();
            jenis.setJenis(resultSet.getString("jenis"));
            jenis.setKeterangan(resultSet.getString("keterangan"));

            joined_id.setJenis(jenis);

            Kondisi kondisi = new Kondisi();
            kondisi.setBody(resultSet.getString("Body"));
            kondisi.setMesin(resultSet.getString("Mesin"));
            kondisi.setCreate_date(resultSet.getString("create_date"));

            joined_id.setKondisi(kondisi);

            joined_ids.add(joined_id);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return joined_ids;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from joined_id_perdana where id_joined_id = ?";

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

        String sql = "delete from joined_id_perdana where id_joined_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE jenis (" +
                " id_jenis int not null primary key auto_increment, " +
                " jenis varchar(255) not null," +
                " keterangan varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE kondisi (" +
                " id_kondisi int not null primary key auto_increment, " +
                " body varchar(255) not null,"+
                " mesin varchar(255) not null,"+
                " create_date date not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE produk (" +
                " id_produk int not null primary key auto_increment, " +
                " nama varchar(255) not null,"+
                " merk varchar(255) not null,"+
                " waktu_pembuatan date not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE joined_id_perdana (" +
                " id_joined_id int not null primary key auto_increment, " +
                " id_produk int not null,"+
                " id_jenis int not null,"+
                " id_kondisi int not null) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_perdana add constraint fk_joined_id_perdana_jenis " +
                " foreign key (id_jenis) references jenis (id_jenis) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_perdana add constraint fk_joined_id_perdana_kondisi " +
                " foreign key (id_kondisi) references kondisi (id_kondisi) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_perdana add constraint fk_joined_id_perdana_produk " +
                " foreign key (id_produk) references produk (id_produk) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}

