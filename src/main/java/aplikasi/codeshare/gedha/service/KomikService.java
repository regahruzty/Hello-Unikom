package main.java.aplikasi.codeshare.gedha.service;

import main.java.aplikasi.codeshare.gedha.model.Komik;
import main.java.aplikasi.codeshare.gedha.repository.KomikRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class KomikService implements KomikRepository {
    private DataSource dataSource;

    public KomikService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Komik save(Komik komik) throws SQLException {
        Connection conn = dataSource.getConnection();
        Long generatedId = null;

        String sql ="INSERT INTO komik  (judul_komik, pengarang, tahun_terbit) values (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setString(1, komik.getJudul_komik());
        preparedStatement.setString(2, komik.getPengarang());
        preparedStatement.setString(3, komik.getTanggal_terbit());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId=getGeneratedKeys.getLong(1);
        }

        komik.setId_komik(generatedId);

        return komik;
    }

    @Override
    public Komik update(Komik value) throws SQLException {
        return null;
    }

    @Override
    public List<Komik> findAll() throws SQLException {
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
