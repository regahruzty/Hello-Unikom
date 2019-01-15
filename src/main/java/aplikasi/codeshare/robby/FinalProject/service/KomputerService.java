package main.java.aplikasi.codeshare.robby.FinalProject.service;

import main.java.aplikasi.codeshare.robby.FinalProject.model.Komputer;
import main.java.aplikasi.codeshare.robby.FinalProject.repository.KomputerRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KomputerService implements KomputerRepository{
    private DataSource dataSource;

    public KomputerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Komputer save(Komputer komputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into komputer (merk, tanggal_bangun) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, komputer.getMerk());
        preparedStatement.setDate(2, komputer.getTanggalBangun());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        komputer.setId_komputer(generatedId);

        return komputer;
    }

    @Override
    public Komputer update(Komputer komputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update komputer set merk = ? , tanggal_bangun = ? where id_komputer = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, komputer.getMerk());
        preparedStatement.setDate(2, komputer.getTanggalBangun());
        preparedStatement.setLong(3, komputer.getId_komputer());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return komputer;
    }

    @Override
    public List<Komputer> findAll() throws SQLException {
        List<Komputer> komputers = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from komputer;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Komputer komputer = new Komputer();
            komputer.setId_komputer(resultSet.getLong("id_komputer"));
            komputer.setMerk(resultSet.getString("merk"));
            komputer.setTanggalBangun(resultSet.getDate("tanggal_bangun"));

            komputers.add(komputer);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return komputers;
    }

    @Override
    public Komputer findOne(Long id) throws SQLException {
        Komputer komputer = new Komputer();
        Connection connection = dataSource.getConnection();

        String sql = "select * from komputer where id_komputer = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            komputer.setId_komputer(resultSet.getLong("id_komputer"));
            komputer.setMerk(resultSet.getString("merk"));
            komputer.setTanggalBangun(resultSet.getDate("tanggal_bangun"));
        }
        return komputer;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from komputer where id_komputer = ?";

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

        String sql = "delete from komputer where id_komputer = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
