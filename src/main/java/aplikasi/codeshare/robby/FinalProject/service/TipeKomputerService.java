package main.java.aplikasi.codeshare.robby.FinalProject.service;

import main.java.aplikasi.codeshare.robby.FinalProject.model.TipeKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.repository.TipeKomputerRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipeKomputerService implements TipeKomputerRepository {
    private DataSource dataSource;

    public TipeKomputerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TipeKomputer save(TipeKomputer tipeKomputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into tipe_komputer (nama) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, tipeKomputer.getNama_tipe());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        tipeKomputer.setId_tipe(generatedId);

        return tipeKomputer;
    }

    @Override
    public TipeKomputer update(TipeKomputer tipeKomputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update tipe_komputer set nama = ? where id_tipe_komputer = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, tipeKomputer.getNama_tipe());
        preparedStatement.setLong(2, tipeKomputer.getId_tipe());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return tipeKomputer;
    }

    @Override
    public List<TipeKomputer> findAll() throws SQLException {
        List<TipeKomputer> tipeKomputers = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from tipe_komputer;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            TipeKomputer tipeKomputer = new TipeKomputer();
            tipeKomputer.setId_tipe(resultSet.getLong("id_tipe_komputer"));
            tipeKomputer.setNama_tipe(resultSet.getString("nama"));

            tipeKomputers.add(tipeKomputer);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return tipeKomputers;
    }

    @Override
    public TipeKomputer findOne(Long id) throws SQLException {
        TipeKomputer tipeKomputer = new TipeKomputer();
        Connection connection = dataSource.getConnection();

        String sql = "select * from pemilik_komputer where id_pemilik_komputer = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            tipeKomputer.setId_tipe(resultSet.getLong("id_tipe_komputer"));
            tipeKomputer.setNama_tipe(resultSet.getString("nama"));
        }
        return tipeKomputer;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from tipe_komputer where id_tipe_komputer = ?";

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

        String sql = "delete from tipe_komputer where id_tipe_komputer = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
