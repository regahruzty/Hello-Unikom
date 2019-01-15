package main.java.aplikasi.codeshare.azizan.TNI.Service;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNI.Model.TentaraAktif;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.TentaraAktifRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TentaraAktifService implements TentaraAktifRepository {
    private DataSource dataSource;

    public TentaraAktifService(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
    }

    @Override
    public TentaraAktif save(TentaraAktif tentaraAktif) throws SQLException {

        Connection connection = dataSource.getConnection();

        Long generatedIid = null;

        String sql = "INSERT INTO tentara_aktif (status_tentara)" +
                "VALUES(?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, tentaraAktif.getStatusTentara());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedIid = getGeneratedKeys.getLong(1);
        }

        tentaraAktif.setIdTentaraAktif(generatedIid);

        return tentaraAktif;
    }

    @Override
    public TentaraAktif update(TentaraAktif tentara) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "UPDATE tentara_aktif SET status_tentara = ? WHERE id_tentara_aktif = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tentara.getStatusTentara());
        preparedStatement.setLong(2, tentara.getIdTentaraAktif());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return tentara;
    }

    @Override
    public List<TentaraAktif> findAll() throws SQLException {
        List<TentaraAktif> tentaraAktifs = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM tentara_aktif";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            TentaraAktif tentaraAktif = new TentaraAktif();
            tentaraAktif.setIdTentaraAktif(resultSet.getLong("id_tentara_aktif"));
            tentaraAktif.setStatusTentara(resultSet.getString("status_tentara"));
            tentaraAktifs.add(tentaraAktif);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return tentaraAktifs;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "SELECT COUNT(*) FROM tentara_aktif WHERE id_tentara_aktif = ?";

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

        String sql = "DELETE FROM tentara_aktif WHERE id_tentara_aktif = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
