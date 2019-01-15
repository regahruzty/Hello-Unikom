package main.java.aplikasi.codeshare.fajar.Final_Project.src.Service;

import main.java.aplikasi.codeshare.fajar.Final_Project.src.Model.*;

import java.util.ArrayList;
import  java.util.List;
import javax.sql.DataSource;
import java.sql.*;

public class ObatRelationService {

    private DataSource dataSource;

    public ObatRelationService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ObatRelation save(ObatRelation obatRelation) throws SQLException {
        Connection connection = dataSource.getConnection();

        int generatedId = 0;

        String sql="insert into obat_relation (id_obat,id_jenis,id_dosis) values (?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, obatRelation.getId_obat().getId_obat());
        preparedStatement.setInt(2, obatRelation.getId_jenis().getId_jenis());
        preparedStatement.setInt(3, obatRelation.getId_dosis().getId_dosis());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId = getGeneratedKeys.getInt(1);
        }

        obatRelation.setId_relation(generatedId);

        return obatRelation;
    }



    public ObatRelation update(ObatRelation obatRelation) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "update obat_relation set id_obat = ?, id_dosis= ?, id_jenis= ? where id_relasi_obat = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, obatRelation.getId_obat().getId_obat());
        preparedStatement.setLong(2, obatRelation.getId_dosis().getId_dosis());
        preparedStatement.setLong(3, obatRelation.getId_jenis().getId_jenis());
        preparedStatement.setLong(4, obatRelation.getId_relation());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

        return obatRelation;
    }


    public List<ObatRelation> findAll() throws SQLException {
        List<ObatRelation> obatRelations = new ArrayList<>();
        ObatRelation obatRelation = new ObatRelation();

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT \n" +
                "obr.id_relasi_obat AS id_relasi,\n" +
                "o.id_obat AS id_obat,\n" +
                "o.nama_obat AS nama_obat,\n" +
                "o.tangal_kadarluarsa AS tanggal_kadarluarsa_obat,\n" +
                "jo.id_jenis AS id_jenis_obat,\n" +
                "jo.jenis AS jenis_obat,\n" +
                "jo.keterangan AS keterangan_obat,\n" +
                "d.id_dosis AS id_dosis_obat,\n" +
                "d.dosis_obat AS dosis_obat\n" +
                "FROM \n" +
                "obat_relation obr JOIN obat o ON obr.id_obat = o.id_obat\n" +
                "JOIN jenis_obat jo ON obr.id_jenis = jo.id_jenis\n" +
                "JOIN dosis d ON obr.id_dosis = d.id_dosis;";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            obatRelation.setId_relation(resultSet.getInt("id_relasi"));

            Obat obat = new Obat();
            obat.setId_obat(resultSet.getInt("id_obat"));
            obat.setNama_obat(resultSet.getString("nama_obat"));
            obat.setNama_obat(resultSet.getString("tanggal_kadarluarsa_obat"));
            obatRelation.setId_obat(obat);

            Dosis dosis = new Dosis();
            dosis.setId_dosis(resultSet.getInt("id_dosis_obat"));
            dosis.setDosis(resultSet.getString("dosis_obat"));

            obatRelation.setId_dosis(dosis);

            Jenis jenis = new Jenis();
            jenis.setId_jenis(resultSet.getInt("id_jenis_obat"));
            jenis.setJenis_obat(resultSet.getString("jenis_obat"));
            jenis.setKeterangan(resultSet.getString("keterangan_obat"));
            obatRelation.setId_dosis(dosis);

            obatRelations.add(obatRelation);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return obatRelations;
    }


    public Boolean exists(Integer id) throws SQLException {
        Long count = 0L;

        Connection connection = dataSource.getConnection();

        String sql = "select count(*) from obat_relation where id_relasi = ?";

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


    public void delete(Integer id) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from obat_relation where id_relasi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    public void deleteByIdObatIdDosisIdJenis(Integer id_obat, Integer id_dosis,Integer id_jenis) throws SQLException {
        Connection connection = dataSource.getConnection();

        String sql = "delete from obat_relation where id_obat = ? and id_dosis = ? and id_jenis = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id_obat);
        preparedStatement.setLong(2, id_dosis);
        preparedStatement.setLong(3, id_jenis);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }




    public void migrate() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        //=========================================================================== Table relasi obat
        String sql = "CREATE TABLE `obat_relation` (\n" +
                "  `id_relasi_obat` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `id_obat` int(11) DEFAULT NULL,\n" +
                "  `id_jenis` int(11) DEFAULT NULL,\n" +
                "  `id_dosis` int(11) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id_relasi_obat`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

        statement.executeUpdate(sql);
        //=========================================================================== table obat
        sql = "CREATE TABLE `obat` (\n" +
                "  `id_obat` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `nama_obat` varchar(255) DEFAULT NULL,\n" +
                "  `tangal_kadarluarsa` DATE DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id_obat`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;\n";

        statement.executeUpdate(sql);
        //=========================================================================== table jenis_obat
        sql = " CREATE TABLE `jenis_obat` (\n" +
                "  `id_jenis` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `jenis` varchar(255) DEFAULT NULL,\n" +
                "  `keterangan` text,\n" +
                "  PRIMARY KEY (`id_jenis`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;";

        statement.executeUpdate(sql);
        //=========================================================================== table dosis
        sql = " CREATE TABLE `dosis` (\n" +
                "  `id_dosis` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `dosis_obat` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id_dosis`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;";

        statement.executeUpdate(sql);
        //=========================================================================== Foreighn KEY
        sql = "alter table obat_relation "
                + " ADD CONSTRAINT fk_table_obat foreign key (id_obat) references obat(id_obat);";
        statement.executeUpdate(sql);

        sql = "alter table obat_relation "
                + " ADD CONSTRAINT fk_table_jenisF foreign key (id_jenis) references jenis_obat(id_jenis);";
        statement.executeUpdate(sql);

        sql = "alter table obat_relation "
                + " ADD CONSTRAINT fk_table_dosisF foreign key (id_dosis) references dosis(id_dosis);";
        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }

    public void ClearingTable() throws SQLException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        //=========================================================================== Table relasi obat
        String sql = "DROP TABLE IF EXISTS `obat_relation` ";

        statement.executeUpdate(sql);
        //=========================================================================== table obat
        sql = "DROP TABLE IF EXISTS `obat`";

        statement.executeUpdate(sql);
        //=========================================================================== table jenis_obat
        sql = "DROP TABLE IF EXISTS `jenis_obat`";

        statement.executeUpdate(sql);
        //=========================================================================== table dosis
        sql = "DROP TABLE IF EXISTS `dosis`";

        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }

}



