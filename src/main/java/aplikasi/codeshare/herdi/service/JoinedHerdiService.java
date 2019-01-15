package main.java.aplikasi.codeshare.herdi.service;

import main.java.aplikasi.codeshare.herdi.model.Burung;
import main.java.aplikasi.codeshare.herdi.model.Jenis;
import main.java.aplikasi.codeshare.herdi.model.JoinedHerdi;
import main.java.aplikasi.codeshare.herdi.model.Sifat;
import main.java.aplikasi.codeshare.herdi.repository.BaseRepository;
import main.java.aplikasi.codeshare.herdi.repository.JoinedHerdiRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JoinedHerdiService implements JoinedHerdiRepository {

    private DataSource dataSource;

    public JoinedHerdiService(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public JoinedHerdi save (JoinedHerdi joinedHerdi) throws SQLException{
        Connection connection = dataSource.getConnection();

        Integer generatedId = 0;

        String sql = "INSERT INTO joined_herdi (id_burung,id_jenis,id_sifat) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1,joinedHerdi.getBurung().getId_burung());
        preparedStatement.setInt(2,joinedHerdi.getJenis().getId_jenis());
        preparedStatement.setInt(3,joinedHerdi.getSifat().getId_sifat());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();

        while(getGeneratedKeys.next()){
        generatedId= ((Long) getGeneratedKeys.getLong(1)).intValue();
        }

        joinedHerdi.setId_joined_herdi(generatedId);

        return joinedHerdi;
    }

    @Override
    public JoinedHerdi update(JoinedHerdi joinedHerdi) throws SQLException {
        Connection connection = dataSource.getConnection();
        String sql = "UPDATE joined_herdi set id_burung = ?, id_jenis = ?, id_sifat = ? where id_joined_herdi = ?";

        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setInt(1,joinedHerdi.getBurung().getId_burung());
        preparedStatement.setInt(2,joinedHerdi.getJenis().getId_jenis());
        preparedStatement.setInt(3,joinedHerdi.getSifat().getId_sifat());
        preparedStatement.setInt(3,joinedHerdi.getId_joined_herdi());

        preparedStatement.executeUpdate(sql);

        preparedStatement.close();
        connection.close();

        return joinedHerdi;
    }

    public void migrate() throws SQLException{

        Connection connection = dataSource.getConnection();

        Statement statement =connection.createStatement();

            String sql = " CREATE TABLE joined_herdi ( " +
                    "   id_joined_herdi INT(11) not null PRIMARY KEY auto_increment, " +
                    "   id_burung INT(11) not null , " +
                    "   id_jenis INT(11) not null , " +
                    "   id_sifat INT(11) not null  " +
                    "   )";
            statement.executeUpdate(sql);

            sql = " CREATE TABLE burung ( " +
                "   id_burung INT(11) not null PRIMARY KEY auto_increment, " +
                "   nama VARCHAR(50) not null , " +
                "   warna VARCHAR(50) not null , " +
                "   paruh VARCHAR(50) not null  " +
                "   )";
        statement.executeUpdate(sql);

        sql = " CREATE TABLE jenis ( " +
                "   id_jenis INT(11) not null PRIMARY KEY auto_increment, " +
                "   jenis VARCHAR(50) not null , " +
                "   desc_jenis VARCHAR(255) not null , " +
                "   )";
        statement.executeUpdate(sql);

        sql = " CREATE TABLE sifat ( " +
                "   id_sifat INT(11) not null PRIMARY KEY auto_increment, " +
                "   sifat VARCHAR(50) not null , " +
                "   desc_sifat VARCHAR(255) not null , " +
                "   )";
        statement.executeUpdate(sql);

            sql = "ALTER TABLE joined_herdi ADD CONSTRAINT " +
                    "fk_burung_id FOREIGN KEY (id_burung) REFERENCES burung (id_burung) ";

            statement.executeUpdate(sql);

            sql = "ALTER TABLE joined_herdi ADD CONSTRAINT " +
                    "fk_jenis_id FOREIGN KEY (id_jenis) REFERENCES jenis (id_jenis) ";

            statement.executeUpdate(sql);

            sql = "ALTER TABLE joined_herdi ADD CONSTRAINT " +
                    "fk_sifat_id FOREIGN KEY (id_sifat) REFERENCES sifat (id_sifat) ";

            statement.executeUpdate(sql);

            statement.close();
            connection.close();
        }

    @Override
    public List findAll() throws SQLException {

    List<JoinedHerdi> joinedHerdiList = new ArrayList<>();
    JoinedHerdi joinedHerdi = new JoinedHerdi();

    Connection connection = dataSource.getConnection();
    Statement statement = connection.createStatement();

    String sql = "SELECT * FROM joined_herdi j JOIN burung b on b.id_burung = j.id_burung JOIN jenis je ON je.id_jenis = j.id_jenis JOIN sifat s ON s.id_sifat = j.id_sifat ";

    ResultSet resultSet =statement.executeQuery(sql);

    while(resultSet.next()){
        joinedHerdi.setId_joined_herdi(resultSet.getInt("id_joined_herdi"));

        //burung
        Burung burung = new Burung();
        burung.setId_burung(resultSet.getInt("id_burung"));
        burung.setNama(resultSet.getString("nama"));
        burung.setWarna(resultSet.getString("warna"));
        burung.setParuh(resultSet.getString("paruh"));

        joinedHerdi.setBurung(burung);

        //jenis
        Jenis jenis = new Jenis();
        jenis.setId_jenis(resultSet.getInt("id_jenis"));
        jenis.setJenis(resultSet.getString("jenis"));
        jenis.setDesc_jenis(resultSet.getString("desc_jenis"));

        joinedHerdi.setJenis(jenis);

        //sifat
        Sifat sifat = new Sifat();
        sifat.setId_sifat(resultSet.getInt("id_sifat"));
        sifat.setSifat(resultSet.getString("sifat"));
        sifat.setDesc_sifat(resultSet.getString("desc_sifat"));

        joinedHerdi.setSifat(sifat);

        joinedHerdiList.add(joinedHerdi);


    }
    resultSet.close();
    connection.close();
    statement.close();


        return joinedHerdiList;
    }

    @Override
    public Boolean exists(Long id) throws SQLException {

        Long count =0L;

        Connection connection = dataSource.getConnection();

        String sql = " SELECT count(*) FROM joined_herdi WHERE id_joined_herdi = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        ResultSet resultSet =preparedStatement.executeQuery();

        while(resultSet.next()){

            count += resultSet.getLong(1);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return count > 0 ? true : false;
    }

    @Override
    public void delete(Long id) throws SQLException {
            Connection connection =dataSource.getConnection();
            String sql = "DELETE FROM joined_herdi WHERE id_joined_herdi = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
    }

    @Override
    public void deleteByIdBurungIdJenisIdSifat(Integer id_burung, Integer id_jenis, Integer id_sifat) throws SQLException {
            Connection connection = dataSource.getConnection();

            String sql = "DELETE FROM joined_herdi WHERE id_burung = ? AND id_jenis = ? AND id_sifat = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_burung);
            preparedStatement.setInt(2,id_jenis);
            preparedStatement.setInt(3,id_sifat);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
    }
}
