package main.java.aplikasi.codeshare.gedha.service;

import main.java.aplikasi.codeshare.gedha.model.Majalah;
import main.java.aplikasi.codeshare.gedha.repository.MajalahRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class MajalahService implements MajalahRepository {
    private DataSource dataSource;

    public MajalahService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Majalah save(Majalah majalah) throws SQLException {

        Connection conn = dataSource.getConnection();
        Long generatedId = null;

        String sql ="INSERT INTO majalah (judul_majalah, pengarang, tahun_terbit) values (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setString(1, majalah.getJudul_majalah());
        preparedStatement.setString(2, majalah.getPengarang());
        preparedStatement.setString(3, majalah.getTanggal_terbit());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId=getGeneratedKeys.getLong(1);
        }

        majalah.setId_majalah(generatedId);

        return majalah;
    }

    @Override
    public Majalah update(Majalah value) throws SQLException {
        return null;
    }

    @Override
    public List<Majalah> findAll() throws SQLException {
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
