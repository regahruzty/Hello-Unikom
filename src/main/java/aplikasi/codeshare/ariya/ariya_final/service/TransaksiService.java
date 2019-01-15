package main.java.aplikasi.codeshare.ariya.ariya_final.service;


import main.java.aplikasi.codeshare.ariya.ariya_final.model.Motor;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Pembeli;
import main.java.aplikasi.codeshare.ariya.ariya_final.model.Transaksi;
import main.java.aplikasi.codeshare.ariya.ariya_final.repository.*;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService implements TransaksiRepository {

    private DataSource dataSource;

    public TransaksiService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Transaksi save(Transaksi transaksi) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into transaksi (id_pembeli, id_motor, tanggal_pembelian, jumlah_pembelian) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, transaksi.getPembeli().getId_pembeli());
        preparedStatement.setLong(2, transaksi.getMotor().getId_motor());
        preparedStatement.setDate(3, (Date) transaksi.getTanggal_pembelian());
        preparedStatement.setLong(4, transaksi.getJumlah_pembelian());


        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        transaksi.setId_transaksi(generatedId);

        return transaksi;
    }

    @Override
    public Transaksi update(Transaksi transaksi) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update transaksi set id_pembeli = ?, id_motor = ?, jumlah_pembelian where id_transaksi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, transaksi.getPembeli().getId_pembeli());
        preparedStatement.setLong(2, transaksi.getMotor().getId_motor());
        preparedStatement.setLong(3, transaksi.getJumlah_pembelian());
        preparedStatement.setLong(3, transaksi.getId_transaksi());


        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return transaksi;
    }

    @Override
    public List<Transaksi> findAll() throws SQLException {
        List<Transaksi> transaksiList= new ArrayList<>();
        Transaksi transaksi = new Transaksi();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select transaksi.id_transaksi as id_transaksi, motor.id_motor as id_motor, motor.nama_motor as nama_motor, pembeli.id_pembeli as id_tumbuhan, pembeli.nama_pembeli as nama_pembeli from transaksi transaksi join motor motor on transaksi.id_motor = motor.id_motor join pembeli pembeli on transaksi.id_pembeli = pembeli.id_pembeli";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            transaksi.setId_transaksi(resultSet.getLong("id_transaksi"));

            Motor motor = new Motor();
            motor.setId_motor(resultSet.getLong("id_motor"));
            motor.setNama_motor(resultSet.getString("nama_motor"));

            transaksi.setMotor(motor);

            Pembeli pembeli = new Pembeli();
            pembeli.setId_pembeli(resultSet.getLong("id_pembeli"));
            pembeli.setNama_pembeli(resultSet.getString("nama_pembeli"));

            transaksi.setPembeli(pembeli);

            transaksiList.add(transaksi);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return transaksiList;
    }


    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from transaksi where id_transaksi = ?";

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

        String sql = "delete from transaksi where id_transaksi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }


    @Override
    public void deleteByIdMotorAndIdPembeli(Long id_motor, Long id_pembeli) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from transaksi where id_motor = ? and id_pembeli = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id_motor);
        preparedStatement.setLong(2, id_pembeli);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }


    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE motor (" +
                " id_motor bigint not null primary key auto_increment, " +
                " nama_motor varchar(255) not null, " +
                " merk_motor varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE pembeli (" +
                " id_pembeli bigint not null primary key auto_increment, " +
                " nama_pembeli varchar(255) not null, " +
                " alamat_pembeli varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE transaksi (" +
                " id_transaksi bigint not null primary key auto_increment, " +
                " id_pembeli bigint not null, " +
                " id_motor bigint not null, " +
                " tanggal_pembelian date not null," +
                " jumlah_pembelian bigint not null)";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE transaksi add constraint fk_transaksi_motor " +
                " foreign key (id_motor) references motor (id_motor) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE transaksi add constraint fk_transaksi_pembeli " +
                " foreign key (id_pembeli) references pembeli (id_pembeli) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
