package Service;

import Model.Dosis;
import Repository.DosisRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class DosisService implements DosisRepository {

    private DataSource dataSource;

    public DosisService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Dosis save(Dosis dosis) throws SQLException {
        Connection connection = dataSource.getConnection();

        int generatedId = 0;

        String sql="insert into dosis (dosis_obat) values (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, dosis.getDosis());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        dosis.setId_dosis(generatedId);

        return dosis;
    }

    @Override
    public Dosis update(Dosis value) throws SQLException {
        return null;
    }

    @Override
    public List<Dosis> findAll() throws SQLException {
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
