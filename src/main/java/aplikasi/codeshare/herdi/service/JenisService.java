package main.java.aplikasi.codeshare.herdi.service;

import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.model.Jenis;
import main.java.aplikasi.codeshare.herdi.repository.BurungRepository;
import main.java.aplikasi.codeshare.herdi.repository.JenisRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisService implements JenisRepository{

    private DataSource dataSource;

    public JenisService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Jenis save(Jenis jenis) throws SQLException {

        Connection connection = dataSource.getConnection();

        Integer generatedId = 0;

        String sql = "INSERT INTO jenis (jenis,desc_jenis) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,jenis.getJenis());
        preparedStatement.setString(2,jenis.getDesc_jenis());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();

        while(getGeneratedKeys.next()){
            generatedId= ((Long) getGeneratedKeys.getLong(1)).intValue();
        }

        jenis.setId_jenis(generatedId);

        return jenis;
    }

    @Override
    public Jenis update(Jenis jenis) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "UPDATE jenis set jenis = ?, desc_jenis = ? where id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, jenis.getJenis());
        preparedStatement.setString(2, jenis.getDesc_jenis());
        preparedStatement.setInt(2, jenis.getId_jenis());

        preparedStatement.executeUpdate(sql);

        preparedStatement.close();
        connection.close();

        return jenis;
    }

    @Override
    public List<Jenis> findAll() throws SQLException {
        List<Jenis> jenisList = new ArrayList<>();


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM jenis";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            //jenis
            Jenis jenis = new Jenis();
            jenis.setId_jenis(resultSet.getInt("id_jenis"));
            jenis.setJenis(resultSet.getString("jenis"));
            jenis.setDesc_jenis(resultSet.getString("desc_jenis"));

            jenisList.add(jenis);

        }

        resultSet.close();
        statement.close();
        connection.close();

        return jenisList;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from jenis where id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            count = count + resultSet.getLong(1);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return count > 0 ? true : false;
    }

    @Override
    public void delete(Long id) throws SQLException {

        Connection connection = dataSource.getConnection();

        String sql = "delete from jenis where id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
