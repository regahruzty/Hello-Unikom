package main.java.aplikasi.codeshare.ariya.ariya_final.service;


import main.java.aplikasi.codeshare.ariya.ariya_final.model.*;

import javax.sql.DataSource;
import java.sql.*;

public class TransaksiService {

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
