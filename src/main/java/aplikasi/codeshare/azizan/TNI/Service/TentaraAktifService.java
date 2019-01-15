package main.java.aplikasi.codeshare.azizan.TNI.Service;

import main.java.aplikasi.codeshare.azizan.Config.KoneksiDB;
import main.java.aplikasi.codeshare.azizan.TNI.Model.TentaraAktif;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.TentaraAktifRepository;

import javax.sql.DataSource;
import java.sql.*;
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
    public TentaraAktif update(TentaraAktif value) throws SQLException {
        return null;
    }

    @Override
    public List<TentaraAktif> findAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
