package main.java.aplikasi.codeshare.riyan.service;

import main.java.aplikasi.codeshare.riyan.model.Joined_id_riyan;

import javax.sql.DataSource;
import java.sql.*;

public class JoinedIDRiyanService {
    private DataSource dataSource;

    public JoinedIDRiyanService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Joined_id_riyan save (Joined_id_riyan joined_id_riyan) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into joined_id_riyan (id_boothcamp, id_pengajar, id_peserta) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, joined_id_riyan.getBoothcamp().getId_boothcamp());
        preparedStatement.setLong(2, joined_id_riyan.getPengajar().getId_pengajar());
        preparedStatement.setLong(3, joined_id_riyan.getPeserta().getId_peserta());


        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        joined_id_riyan.setId_joined_riyan(generatedId);

        return joined_id_riyan;



    }

    public void migrate() throws SQLException {
        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE boothcamp (" +
                " id_boothcamp bigint not null primary key auto_increment, " +
                " nama_boothcamp varchar(255) not null, " +
                " lokasi varchar(255) not null, " +
                " alamat varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE pengajar (" +
                " id_pengajar bigint not null primary key auto_increment, " +
                " nama_pengajar varchar(255) not null, " +
                " no_telp varchar(255) not null, " +
                " spesialis varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE peserta (" +
                " id_peserta bigint not null primary key auto_increment, " +
                " nama_peserta varchar(255) not null, " +
                " no_telp varchar(255) not null, " +
                " alamat varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE joined_id_riyan (" +
                " id_joined_riyan bigint not null primary key auto_increment, " +
                " id_boothcamp bigint not null, " +
                " id_pengajar bigint not null, " +
                " id_peserta bigint not null) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_riyan add constraint fk_joined_id_riyan_boothcamp " +
                " foreign key (id_boothcamp) references boothcamp (id_boothcamp) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_riyan add constraint fk_joined_id_riyan_pengajar " +
                " foreign key (id_pengajar) references pengajar (id_pengajar) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE joined_id_riyan add constraint fk_joined_id_riyan_peserta " +
                " foreign key (id_peserta) references peserta (id_peserta) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();

    }

}
