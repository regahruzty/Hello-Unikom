package main.java.aplikasi.codeshare.gedha.service;

import main.java.aplikasi.codeshare.gedha.model.Buku;
import main.java.aplikasi.codeshare.gedha.repository.BukuRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BukuService implements BukuRepository {
    private DataSource dataSource;

    public BukuService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Buku save(Buku buku) throws SQLException {
        Connection conn = dataSource.getConnection();
        Long generatedId = null;

        String sql ="INSERT INTO buku  (judul_buku, pengarang, tahun_terbit) values (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setString(1, buku.getJudul_buku());
        preparedStatement.setString(2, buku.getPengarang());
        preparedStatement.setString(3, buku.getTanggal_terbit());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId=getGeneratedKeys.getLong(1);
        }

        buku.setId_buku(generatedId);

        return buku;
    }

    @Override
    public Buku update(Buku value) throws SQLException {
        return null;
    }

    @Override
    public List<Buku> findAll() throws SQLException {
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



