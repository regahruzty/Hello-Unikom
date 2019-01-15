package Service;

import Model.Jenis;
import Repository.JenisRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class JenisService implements JenisRepository {

    private DataSource dataSource;

    public JenisService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Jenis save(Jenis jenis) throws SQLException {
        Connection connection = dataSource.getConnection();

        int generatedId = 0;

        String sql="insert into jenis_obat (jenis,keterangan) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, jenis.getJenis_obat());
        preparedStatement.setString(2, jenis.getKeterangan());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        jenis.setId_jenis(generatedId);

        return jenis;
    }

    @Override
    public Jenis update(Jenis value) throws SQLException {
        return null;
    }

    @Override
    public List<Jenis> findAll() throws SQLException {
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
