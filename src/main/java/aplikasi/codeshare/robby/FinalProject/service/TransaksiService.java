package main.java.aplikasi.codeshare.robby.FinalProject.service;

import main.java.aplikasi.codeshare.robby.FinalProject.model.Komputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.PemilikKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.TipeKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.model.Transaksi;
import main.java.aplikasi.codeshare.robby.FinalProject.repository.TransaksiRepository;

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

        String sql="insert into joined_id_robby (id_komputer, id_tipe_komputer, id_pemilik_komputer) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, transaksi.getKomputer().getId_komputer());
        preparedStatement.setLong(2, transaksi.getTipeKomputer().getId_tipe());
        preparedStatement.setLong(3, transaksi.getPemilikKomputer().getId_pemilik_komputer());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        transaksi.setIdJoinedID(generatedId);

        return transaksi;
    }

    @Override
    public Transaksi update(Transaksi transaksi) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update joined_id_robby set id_komputer = ? , id_tipe_komputer = ? , id_pemilik_komputer = ? where id_joined_id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, transaksi.getKomputer().getId_komputer());
        preparedStatement.setLong(2, transaksi.getTipeKomputer().getId_tipe());
        preparedStatement.setLong(3, transaksi.getPemilikKomputer().getId_pemilik_komputer());
        preparedStatement.setLong(4, transaksi.getIdJoinedID());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return transaksi;
    }

    @Override
    public List<Transaksi> findAll() throws SQLException {
        List<Transaksi> transaksis = new ArrayList<>();


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select trans.id_joined_id as id_joined_id, komputer.id_komputer as id_komputer," +
                " komputer.merk as merk, komputer.tanggal_bangun as tanggal_bangun," +
                " pemilik.id_pemilik_komputer as id_pemilik_komputer, pemilik.nama as nama," +
                " tipe.id_tipe_komputer as id_tipe_komputer, tipe.nama as nama " +
                " from joined_id_robby trans join komputer on trans.id_komputer = komputer.id_komputer" +
                " join pemilik_komputer pemilik on trans.id_pemilik_komputer = pemilik.id_pemilik_komputer" +
                " join tipe_komputer tipe on trans.id_tipe_komputer = tipe.id_tipe_komputer;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Transaksi transaksi = new Transaksi();
            transaksi.setIdJoinedID(resultSet.getLong("id_joined_id"));

            Komputer komputer = new Komputer();
            komputer.setId_komputer(resultSet.getLong("id_komputer"));
            komputer.setMerk(resultSet.getString("merk"));
            komputer.setTanggalBangun(resultSet.getDate("tanggal_bangun"));

            transaksi.setKomputer(komputer);

            PemilikKomputer pemilikKomputer = new PemilikKomputer();
            pemilikKomputer.setId_pemilik_komputer(resultSet.getLong("id_pemilik_komputer"));
            pemilikKomputer.setNama_pemilik_komputer(resultSet.getString("nama"));

            transaksi.setPemilikKomputer(pemilikKomputer);

            TipeKomputer tipeKomputer = new TipeKomputer();
            tipeKomputer.setId_tipe(resultSet.getLong("id_tipe_komputer"));
            tipeKomputer.setNama_tipe(resultSet.getString("nama"));

            transaksi.setTipeKomputer(tipeKomputer);

            transaksis.add(transaksi);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return transaksis;
    }

    @Override
    public Transaksi findOne(Long id) throws SQLException {
        Transaksi transaksi = new Transaksi();
        Connection connection = dataSource.getConnection();

        String sql = "select trans.id_joined_id as id_joined_id, komputer.id_komputer as id_komputer," +
                " komputer.merk as merk, komputer.tanggal_bangun as tanggal_bangun," +
                " pemilik.id_pemilik_komputer as id_pemilik_komputer, pemilik.nama as nama," +
                " tipe.id_tipe_komputer as id_tipe_komputer, tipe.nama as nama " +
                " from joined_id_robby trans join komputer on trans.id_komputer = komputer.id_komputer" +
                " join pemilik_komputer pemilik on trans.id_pemilik_komputer = pemilik.id_pemilik_komputer" +
                " join tipe_komputer tipe on trans.id_tipe_komputer = tipe.id_tipe_komputer where id_joined_id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            transaksi.setIdJoinedID(resultSet.getLong("id_joined_id"));

            Komputer komputer = new Komputer();
            komputer.setId_komputer(resultSet.getLong("id_komputer"));
            komputer.setMerk(resultSet.getString("merk"));
            komputer.setTanggalBangun(resultSet.getDate("tanggal_bangun"));

            transaksi.setKomputer(komputer);

            PemilikKomputer pemilikKomputer = new PemilikKomputer();
            pemilikKomputer.setId_pemilik_komputer(resultSet.getLong("id_pemilik_komputer"));
            pemilikKomputer.setNama_pemilik_komputer(resultSet.getString("nama"));

            transaksi.setPemilikKomputer(pemilikKomputer);

            TipeKomputer tipeKomputer = new TipeKomputer();
            tipeKomputer.setId_tipe(resultSet.getLong("id_tipe_komputer"));
            tipeKomputer.setNama_tipe(resultSet.getString("nama"));

            transaksi.setTipeKomputer(tipeKomputer);
        }
        return transaksi;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from joined_id_robby where id_joined_id = ?";

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

        String sql = "delete from id_joined_robby where id_joined_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteByIdKomputerDanPemilik(Long idKomputer, Long idPemilik) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from joined_id_robby where id_komputer = ? and id_pemilik_komputer = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, idKomputer);
        preparedStatement.setLong(2, idPemilik);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " create table komputer(" +
                "id_komputer BIGINT not null auto_increment primary key," +
                "merk varchar(255) not null," +
                "tanggal_bangun date not null" +
                ");";

        statement.executeUpdate(sql);

        sql = " create table tipe_komputer(" +
                "id_tipe_komputer BIGINT not null auto_increment primary key," +
                "nama varchar(255) not null" +
                ");";

        statement.executeUpdate(sql);

        sql = " create table pemilik_komputer(" +
                "id_pemilik_komputer BIGINT not null PRIMARY KEY auto_increment," +
                "nama VARCHAR(255) not null" +
                ");";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE joined_id_robby ( " +
                "   id_joined_id BIGINT not null PRIMARY KEY auto_increment, " +
                "   id_komputer BIGINT not null , " +
                "   id_tipe_komputer BIGINT not null , " +
                "   id_pemilik_komputer BIGINT not null  " +
                "   )";

        statement.executeUpdate(sql);

        sql = " alter table joined_id_robby add constraint " +
                " fk_table_komputer foreign key (id_komputer) references komputer(id_komputer) ";

        statement.executeUpdate(sql);

        sql = " alter table joined_id_robby add constraint " +
                " fk_table_pemilik_komputer foreign key (id_pemilik_komputer) references pemilik_komputer(id_pemilik_komputer) ";

        statement.executeUpdate(sql);

        sql = " alter table joined_id_robby add constraint " +
                " fk_table_tipe_komputer foreign key (id_tipe_komputer) references tipe_komputer(id_tipe_komputer) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
