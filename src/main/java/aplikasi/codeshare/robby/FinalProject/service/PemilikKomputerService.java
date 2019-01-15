package main.java.aplikasi.codeshare.robby.FinalProject.service;

import main.java.aplikasi.codeshare.robby.FinalProject.model.PemilikKomputer;
import main.java.aplikasi.codeshare.robby.FinalProject.repository.PemilikKomputerRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PemilikKomputerService implements PemilikKomputerRepository {
    private DataSource dataSource;

    public PemilikKomputerService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public PemilikKomputer save(PemilikKomputer pemilikKomputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into pemilik_komputer (nama) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pemilikKomputer.getNama_pemilik_komputer());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        pemilikKomputer.setId_pemilik_komputer(generatedId);

        return pemilikKomputer;
    }

    @Override
    public PemilikKomputer update(PemilikKomputer pemilikKomputer) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update pemilik_komputer set nama = ? where id_komputer = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, pemilikKomputer.getNama_pemilik_komputer());
        preparedStatement.setLong(2, pemilikKomputer.getId_pemilik_komputer());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return pemilikKomputer;
    }

    @Override
    public List<PemilikKomputer> findAll() throws SQLException {
        List<PemilikKomputer> pemilikKomputers = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from pemilik_komputer;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            PemilikKomputer pemilikKomputer = new PemilikKomputer();
            pemilikKomputer.setId_pemilik_komputer(resultSet.getLong("id_pemilik_komputer"));
            pemilikKomputer.setNama_pemilik_komputer(resultSet.getString("nama"));

            pemilikKomputers.add(pemilikKomputer);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return pemilikKomputers;
    }

    @Override
    public PemilikKomputer findOne(Long id) throws SQLException {
        PemilikKomputer pemilikKomputer = new PemilikKomputer();
        Connection connection = dataSource.getConnection();

        String sql = "select * from pemilik_komputer where id_pemilik_komputer = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            pemilikKomputer.setId_pemilik_komputer(resultSet.getLong("id_pemilik_komputer"));
            pemilikKomputer.setNama_pemilik_komputer(resultSet.getString("nama"));
        }
        return pemilikKomputer;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from pemilik_komputer where id_pemilik_komputer = ?";

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

        String sql = "delete from pemilik_komputer where id_pemilik_komputer = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
