package main.java.aplikasi.codeshare.gedha.service;

import main.java.aplikasi.codeshare.gedha.model.Koleksi;
import main.java.aplikasi.codeshare.gedha.repository.KoleksiRepository;
import main.java.aplikasi.repository.BaseRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class KoleksiService {
    private DataSource dataSource;

    public KoleksiService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Koleksi save(Koleksi koleksi) throws SQLException {
        Connection conn = dataSource.getConnection();
        Long generatedId = null;

        String sql ="INSERT INTO koleksi (id_buku, id_komik, id_majalah) values (?,?,?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setLong(1, koleksi.getBuku().getId_buku());
        preparedStatement.setLong(2, koleksi.getKomik().getId_komik());
        preparedStatement.setLong(3, koleksi.getMajalah().getId_majalah());

        preparedStatement.executeUpdate();

        ResultSet getGeneratedKeys = preparedStatement.getGeneratedKeys();
        while (getGeneratedKeys.next()){
            generatedId=getGeneratedKeys.getLong(1);
        }

        koleksi.setId_koleksi(generatedId);

        return koleksi;
    }

    public void migrate() throws SQLException {
        Connection conn = dataSource.getConnection();

        Statement stmt = conn.createStatement();

        String sql ="CREATE TABLE koleksi (" +
                " id_koleksi bigint not null primary key auto_increment, " +
                " id_buku bigint(11) not null, " +
                " id_komik bigint(11) not null, " +
                " id_majalah bigint(11) not null) ";
        stmt.executeUpdate(sql);

        sql ="CREATE TABLE buku(" +
                " id_buku bigint(11) not null primary key auto_increment, " +
                " judul_buku varchar(255) not null, " +
                " pengarang varchar(255) not null, " +
                " tahun_terbit varchar(255) not null) ";
        stmt.executeUpdate(sql);

        sql ="CREATE TABLE komik(" +
                " id_komik bigint(11) not null primary key auto_increment, " +
                " judul_majalah varchar(255) not null, " +
                " pengarang varchar(255) not null, " +
                " tahun_terbit varchar(255) not null) ";
        stmt.executeUpdate(sql);

        sql ="CREATE TABLE majalah("+
                " id_majalah bigint(11) not null primary key auto_increment, "+
                " judul_majalah varchar(255) not null, "+
                " pengarang varchar(255) not null, "+
                " tahun_terbit varchar(255) not null) ";
        stmt.executeUpdate(sql);

        //Buku
        sql=" alter table koleksi add constraint fk_tabel_buku " +
                " foreign key (id_buku) references buku (id_buku)";
        stmt.executeUpdate(sql);

        //Komik
        sql=" alter table koleksi add constraint fk_tabel_komik " +
                " foreign key (id_komik) references komik (id_komik)";
        stmt.executeUpdate(sql);
        //Majalah
        sql=" alter table koleksi add constraint fk_tabel_majalah " +
                "foreign key (id_majalah) references majalah (id_majalah)";
        stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

    }

    public void delete(Long id)throws SQLException{
        Connection connection = dataSource.getConnection();

        String sql = "delete from koleksi where id_koleksi = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
