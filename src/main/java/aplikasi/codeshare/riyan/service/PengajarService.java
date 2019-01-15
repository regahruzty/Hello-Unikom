package main.java.aplikasi.codeshare.riyan.service;

import main.java.aplikasi.codeshare.riyan.model.Pengajar;
import main.java.aplikasi.codeshare.riyan.repository.PengajarRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class PengajarService implements PengajarRepository {
    private DataSource dataSource;

    public PengajarService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Pengajar save(Pengajar pengajar) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long genertedId = null;

        String sql="insert into pengajar (nama_pengajar, no_telp, spesialis) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, pengajar.getNama_pengajar());
        preparedStatement.setString(2, pengajar.getNo_telp());
        preparedStatement.setString(3, pengajar.getSpesialis());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            genertedId = getGeneratedKeys.getLong(1);
        }

        pengajar.setId_pengajar(genertedId);

        return pengajar;
    }

    @Override
    public Pengajar update(Pengajar value) throws SQLException {
        return null;
    }

    @Override
    public List<Pengajar> findALL() throws SQLException {
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
