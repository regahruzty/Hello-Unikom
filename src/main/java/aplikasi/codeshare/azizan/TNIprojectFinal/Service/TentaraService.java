package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Service;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.Tentara;
import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Repository.TentaraRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
    public Tentara update(Tentara tentara) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "UPDATE tentara SET nama_tentara = ? WHERE id_tentara = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tentara.getNamaTentara());
        preparedStatement.setLong(2, tentara.getIdTentara());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return tentara;
    }

    @Override
    public List<Tentara> findAll() throws SQLException {
        List<Tentara> tentaras = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM tentara";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Tentara tentara = new Tentara();
            tentara.setIdTentara(resultSet.getLong("id_tentara"));
            tentara.setNamaTentara(resultSet.getString("nama_tentara"));
            tentara.setPangkat(resultSet.getString("pangkat"));
            tentara.setMatra(resultSet.getString("matra"));
            tentara.setPerwira(resultSet.getBoolean("is_perwira"));
            tentaras.add(tentara);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return tentaras;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "SELECT COUNT(*) FROM tentara WHERE id_tentara = ?";

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

        String sql = "DELETE FROM tentara WHERE id_tentara = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

}
