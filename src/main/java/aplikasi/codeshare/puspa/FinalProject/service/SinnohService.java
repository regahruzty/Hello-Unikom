package main.java.aplikasi.codeshare.puspa.FinalProject.service;

import model.Fire;
import model.Sinnoh;
import model.Water;
import repository.SinnohRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinnohService implements SinnohRepository {
    private DataSource dataSource;

    public SinnohService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Sinnoh save(Sinnoh sinnoh) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into sinnoh (id_fire, id_water) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, sinnoh.getFire().getIdFire());
        preparedStatement.setLong(2, sinnoh.getWater().getIdWater());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        sinnoh.setIdSinnoh(generatedId);

        return sinnoh;
    }

    @Override
    public Sinnoh update(Sinnoh sinnoh) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update sinnoh set id_fire = ?, id_water = ? where id_sinnoh = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, sinnoh.getFire().getIdFire());
        preparedStatement.setLong(2, sinnoh.getWater().getIdWater());
        preparedStatement.setLong(2, sinnoh.getIdSinnoh());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return sinnoh;
    }

    @Override
    public List<Sinnoh> findAll() throws SQLException {
        List<Sinnoh> sinnohs = new ArrayList<>();
        Sinnoh sinnoh = new Sinnoh();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select sin.id_sinnoh as id_sinnoh, fir.id_fire as id_fire, fir.nama_fire as nama_fire, wat.id_water as id_water, wat.nama_water as nama_water from sinnoh sin join fire fir on sin.id_fire = fir.id_fire join water wat on sin.id_water = wat.id_water ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            sinnoh.setIdSinnoh(resultSet.getLong("id_sinnoh"));

            Fire fire = new Fire();
            fire.setIdFire(resultSet.getLong("id_fire"));
            fire.setNamaFire(resultSet.getString("nama_fire"));

            sinnoh.setFire(fire);

            Water water = new Water();
            water.setIdWater(resultSet.getLong("id_water"));
            water.setNamaWater(resultSet.getString("nama_water"));

            sinnoh.setWater(water);

            sinnohs.add(sinnoh);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return sinnohs;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from sinnoh where id_sinnoh = ?";

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

        String sql = "delete from sinnoh where id_sinnoh = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteByIdFireAndIdWater(Long idFire, Long idWater) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from sinnoh where id_fire = ? and id_water = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, idFire);
        preparedStatement.setLong(2, idWater);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE fire (" +
                " id_fire bigint not null primary key auto_increment, " +
                " nama_fire varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE water (" +
                " id_water bigint not null primary key auto_increment, " +
                " nama_water varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE sinnoh (" +
                " id_sinnoh bigint not null primary key auto_increment, " +
                " id_fire bigint not null, " +
                " id_water bigint not null )";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE sinnoh add constraint fk_fire " +
                " foreign key (id_fire) references fire (id_fire) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE sinnoh add constraint fk_water " +
                " foreign key (id_water) references water (id_water) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
