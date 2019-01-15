package main.java.aplikasi.codeshare.herdi.service;

import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.repository.BurungRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BurungService implements BurungRepository {

    private DataSource dataSource;

    public BurungService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Burung save(Burung burung) throws SQLException {

        Connection connection = dataSource.getConnection();

        Integer generatedId = 0;

        String sql = "INSERT INTO burung (nama,warna,paruh) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, burung.getNama());
        preparedStatement.setString(2, burung.getWarna());
        preparedStatement.setString(3, burung.getParuh());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();

        while (getGeneratedKeys.next()) {
            generatedId = ((Long) getGeneratedKeys.getLong(1)).intValue();
        }

        burung.setId_burung(generatedId);

        return burung;

    }

    @Override
    public Burung update(Burung burung) {


        try {
            Connection connection = dataSource.getConnection();
            String sql = "UPDATE burung SET nama = ?, warna = ?, paruh = ? where id_burung = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, burung.getNama());
            preparedStatement.setString(2, burung.getWarna());
            preparedStatement.setString(3, burung.getParuh());
            preparedStatement.setInt(4, burung.getId_burung());

            preparedStatement.executeUpdate(sql);

            preparedStatement.close();
            connection.close();
        }catch (SQLException ex){
            System.out.println(ex.getErrorCode());
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }



        return burung;

    }

    @Override
    public List<Burung> findAll() throws SQLException {

        List<Burung> burungList = new ArrayList<>();


        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM burung";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            //burung
            Burung burung = new Burung();
            burung.setId_burung(resultSet.getInt("id_burung"));
            burung.setNama(resultSet.getString("nama"));
            burung.setWarna(resultSet.getString("warna"));
            burung.setParuh(resultSet.getString("paruh"));

            burungList.add(burung);

        }

        resultSet.close();
        statement.close();
        connection.close();

        return burungList;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from burung where id_burung = ?";

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

        String sql = "delete from burung where id_burung = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
