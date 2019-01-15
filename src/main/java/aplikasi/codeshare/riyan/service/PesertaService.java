package main.java.aplikasi.codeshare.riyan.service;

import main.java.aplikasi.codeshare.riyan.model.Peserta;
import main.java.aplikasi.codeshare.riyan.repository.PesertaRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class PesertaService implements PesertaRepository {

    private DataSource dataSource;

    public PesertaService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Peserta save(Peserta peserta) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into peserta (nama_peserta, no_telp, alamat) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, peserta.getNama_peserta());
        preparedStatement.setString(2, peserta.getNo_telp());
        preparedStatement.setString(3, peserta.getAlamat());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        peserta.setId_peserta(generatedId);

        return peserta;
    }

    @Override
    public Peserta update(Peserta value) throws SQLException {
        return null;
    }

    @Override
    public List<Peserta> findALL() throws SQLException {
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
