package main.java.aplikasi.codeshare.fajar.Final_Project.src.Service;

import main.java.aplikasi.codeshare.fajar.Final_Project.src.Model.Obat;
import main.java.aplikasi.codeshare.fajar.Final_Project.src.Repository.ObatRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ObatService implements ObatRepository {

    private DataSource dataSource;

    public ObatService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Obat save(Obat obat) throws SQLException {
        Connection connection = dataSource.getConnection();

        int generatedId = 0;

        String sql="insert into obat (nama_obat,tangal_kadarluarsa) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, obat.getNama_obat());
        preparedStatement.setDate(2, obat.getTgl_kadarluarsa());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        obat.setId_obat(generatedId);

        return obat;
    }

    @Override
    public Obat update(Obat value) throws SQLException {
        return null;
    }

    @Override
    public List<Obat> findAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
