package main.java.finalproject.service;

import main.java.finalproject.model.Ekosistem;
import main.java.finalproject.model.Hewan;
import main.java.finalproject.model.Tumbuhan;
import main.java.finalproject.repository.EkosistemRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EkosistemService implements EkosistemRepository {

    private DataSource dataSource;

    public EkosistemService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Ekosistem save(Ekosistem ekosistem) throws SQLException {
        Connection connection = dataSource.getConnection();

        Long generatedId = null;

        String sql="insert into ekosistem (id_hewan, id_tumbuhan) values (?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setLong(1, ekosistem.getHewan().getIdHewan());
        preparedStatement.setLong(2, ekosistem.getTumbuhan().getIdTumbuhan());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getLong(1);
        }

        ekosistem.setIdEkosistem(generatedId);

        return ekosistem;
    }


    @Override
    public Ekosistem update(Ekosistem ekosistem) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update ekosistem set id_hewan = ?, id_tumbuhan = ? where id_ekosistem = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, ekosistem.getHewan().getIdHewan());
        preparedStatement.setLong(2, ekosistem.getTumbuhan().getIdTumbuhan());
        preparedStatement.setLong(2, ekosistem.getIdEkosistem());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return ekosistem;
    }

    @Override
    public List<Ekosistem> findAll() throws SQLException {
        List<Ekosistem> ekosistems = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select eko.id_ekosistem as id_ekosistem, hew.id_hewan as id_hewan, hew.nama_hewan as nama_hewan, tum.id_tumbuhan as id_tumbuhan, tum.nama_tumbuhan as nama_tumbuhan from ekosistem eko join hewan hew on eko.id_hewan = hew.id_hewan join tumbuhan tum on eko.id_tumbuhan = tum.id_tumbuhan ";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Ekosistem ekosistem = new Ekosistem();
            ekosistem.setIdEkosistem(resultSet.getLong("id_ekosistem"));

            Hewan hewan = new Hewan();
            hewan.setIdHewan(resultSet.getLong("id_hewan"));
            hewan.setNamaHewan(resultSet.getString("nama_hewan"));

            ekosistem.setHewan(hewan);

            Tumbuhan tumbuhan = new Tumbuhan();
            tumbuhan.setIdTumbuhan(resultSet.getLong("id_tumbuhan"));
            tumbuhan.setNamaTumbuhan(resultSet.getString("nama_tumbuhan"));

            ekosistem.setTumbuhan(tumbuhan);

            ekosistems.add(ekosistem);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return ekosistems;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from ekosistem where id_ekosistem = ?";

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

        String sql = "delete from ekosistem where id_ekosistem = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Override
    public void deleteByIdHewanAndIdTumbuhan(Long idHewan, Long idTumbuhan) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from ekosistem where id_hewan = ? and id_tumbuhan = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, idHewan);
        preparedStatement.setLong(2, idTumbuhan);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        String sql = " CREATE TABLE ekosistem (" +
                " id_ekosistem bigint not null primary key auto_increment, " +
                " nama_ekosistem varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE tumbuhan (" +
                " id_tumbuhan bigint not null primary key auto_increment, " +
                " nama_tumbuhan varchar(255) not null) ";

        statement.executeUpdate(sql);

        sql = " CREATE TABLE ekosistem (" +
                " id_ekosistem bigint not null primary key auto_increment, " +
                " id_ekosistem bigint not null, " +
                " id_tumbuhan bigint not null )";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE ekosistem add constraint fk_ekosistem_ekosistem " +
                " foreign key (id_ekosistem) references ekosistem (id_ekosistem) ";

        statement.executeUpdate(sql);

        sql = " ALTER TABLE ekosistem add constraint fk_ekosistem_tumbuhan " +
                " foreign key (id_tumbuhan) references tumbuhan (id_tumbuhan) ";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
