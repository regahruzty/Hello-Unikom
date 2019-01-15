package main.java.aplikasi.codeshare.azizan.TNI.Service;

import main.java.aplikasi.codeshare.azizan.TNI.Model.TNI;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.TNIRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class TNIService implements TNIRepository {
    private DataSource dataSource;

    public TNIService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TNI save(TNI tni) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql = "INSERT INTO tni (id_tentara, id_batalyon, id_tentara_aktif)" +
                "VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setLong(1, tni.getTentara().getIdTentara() );
        preparedStatement.setLong(2, tni.getBatalyon().getIdBayalyon());
        preparedStatement.setLong(3, tni.getTentaraAktif().getIdTentaraAktif());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        tni.setIdTNI(generatedId);

        return tni;
    }

    @Override
    public TNI update(TNI value) throws SQLException {
        return null;
    }

    @Override
    public List<TNI> findAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long id) throws SQLException {

    }
    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE tni (" +
                " id_tni bigint not null primary key auto_increment, " +
                " id_tentara bigint not null," +
                " id_batalyon bigint not null," +
                " id_tentara_aktif bigint not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE tentara (" +
                " id_tentara bigint not null primary key auto_increment, " +
                " nama_tentara varchar(255) not null," +
                " pangkat varchar(255) not null," +
                " matra varchar(255) not null," +
                " is_perwira bit(1) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE tentara_aktif (" +
                " id_tentara_aktif bigint not null primary key auto_increment, " +
                " status_tentara varchar(255) not null)";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE batalyon (" +
                " id_batalyon bigint not null primary key auto_increment, " +
                " nama_batalyon varchar(255) not null)";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_tentara " +
                " foreign key (id_tentara) references tentara (id_tentara) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_tentaraaktif " +
                " foreign key (id_tentara_aktif) references tentara_aktif (id_tentara_aktif) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE tni add constraint fk_tni_batalyon " +
                " foreign key (id_batalyon) references batalyon (id_batalyon) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
