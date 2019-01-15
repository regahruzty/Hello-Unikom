package main.java.aplikasi.codeshare.azizan.TNI.Service;

import main.java.aplikasi.codeshare.azizan.TNI.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNI.Repository.TentaraRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class TentaraService implements TentaraRepository {

    private DataSource dataSource;

    public TentaraService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Tentara save(Tentara tentara) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="INSERT INTO TENTARA (nama_tentara, pangkat, matra, is_perwira)" +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, tentara.getNamaTentara());
        preparedStatement.setString(2, tentara.getPangkat());
        preparedStatement.setString(3, tentara.getMatra());
        preparedStatement.setBoolean(4, tentara.isPerwira());
        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        tentara.setIdTentara(generatedId);

        return tentara;
    }

    @Override
    public Tentara update(Tentara value) throws SQLException {
        return null;
    }

    @Override
    public List<Tentara> findAll() throws SQLException {
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
