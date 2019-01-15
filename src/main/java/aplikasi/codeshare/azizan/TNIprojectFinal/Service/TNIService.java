package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Batalyon;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.TNI;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.TentaraAktif;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Repository.TNIRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
        List<TNI> tnis = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT tni.id_tni AS id_tni, tentara.id_tentara AS id_tentara, tentara.nama_tentara AS nama_tentara, tentara.pangkat AS pangkat, tentara.matra AS matra, tentara.is_perwira AS is_perwira, tentara_aktif.id_tentara_aktif AS id_tentara_aktif, tentara_aktif.status_tentara AS status_tentara, batalyon.id_batalyon AS id_batalyon, batalyon.nama_batalyon AS nama_batalyon FROM tni JOIN tentara ON tni.id_tentara = tentara.id_tentara JOIN batalyon ON tni.id_batalyon = batalyon.id_batalyon JOIN tentara_aktif ON tni.id_tentara_aktif = tentara_aktif.id_tentara_aktif";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            TNI tni = new TNI();
            tni.setIdTNI(resultSet.getLong("id_tni"));
            Tentara tentara = new Tentara();
            tentara.setIdTentara(resultSet.getLong("id_tentara"));
            tentara.setNamaTentara(resultSet.getString("nama_tentara"));
            tentara.setPangkat(resultSet.getString("pangkat"));
            tentara.setMatra(resultSet.getString("matra"));
            tentara.setPerwira(resultSet.getBoolean("is_perwira"));

            tni.setTentara(tentara);

            TentaraAktif tentaraAktif = new TentaraAktif();
            tentaraAktif.setIdTentaraAktif(resultSet.getLong("id_tentara_aktif"));
            tentaraAktif.setStatusTentara(resultSet.getString("status_tentara"));

            tni.setTentaraAktif(tentaraAktif);

            Batalyon batalyon = new Batalyon();
            batalyon.setIdBayalyon(resultSet.getLong("id_batalyon"));
            batalyon.setNamaBatalyon(resultSet.getString("nama_batalyon"));

            tni.setBatalyon(batalyon);

            tnis.add(tni);

        }

        resultSet.close();
        statement.close();
        connection.close();

        return tnis;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "SELECT COUNT(*) FROM tni WHERE id_tni = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
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

        String sql = "DELETE FROM tni WHERE id_tni = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteByIdTentaraAndIdTentaraAktifAndIdBatalyon(Long idTentara, Long idTentaraAktif, Long idBatalyon) throws SQLException {
        Connection connection = dataSource.getConnection();

        String  sql ="DELETE FROM tni WHERE id_tentara = ? AND id_tentara_aktif = ?" +
                " AND id_batalyon = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, idTentara);
        preparedStatement.setLong(2, idTentaraAktif);
        preparedStatement.setLong(3, idBatalyon);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
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
