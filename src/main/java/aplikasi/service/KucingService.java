package main.java.aplikasi.service;

import main.java.aplikasi.config.KoneksiDB;
import main.java.aplikasi.model.Kucing;
import main.java.aplikasi.repository.KucingRepository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author regahruzty
 */
public class KucingService implements KucingRepository {

    private DataSource ds;

    public KucingService(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Kucing save(Kucing value) throws SQLException {
        Connection conn = ds.getConnection();
        long generatedValue = Save.initProcess(conn, value);
        value.setKucingId(generatedValue);
        return value;
    }

    @Override
    public Kucing update(Kucing value) throws SQLException {
        return null;
    }

    @Override
    public List<Kucing> findAll() throws SQLException {
        return null;
    }

    @Override
    public Kucing findOne(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Boolean exists(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {

    }

    @Override
    public List<Kucing> selectPemilikKucing() throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        List<Kucing> kucingList = SelectPemilikKucing.initProcess(conn, stmt);
        return kucingList;
    }

    @Override
    public List<Kucing> selectPemilikKucingLiar() throws SQLException {
        return null;
    }
}

class Save {
    public static long initProcess(Connection conn, Kucing value) throws SQLException {
        String sql;

        sql = "INSERT INTO pemilik_kucing (jenis, nama, is_liar, tanggal_lahir, jumlah_kaki) "
                + "VALUES (?, ?, ?, ?, ?)";

        long generatedId = coreProcess(conn, sql, value);
        return generatedId;
    }

    public static long coreProcess(Connection conn, String sql, Kucing value) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, value.getJenis());
        ps.setString(2, value.getNama());
        ps.setInt(5, value.getJumlahKaki());
        ps.setBoolean(3, value.getLiar());
        ps.setDate(4, new java.sql.Date(value.getTanggalLahir().getTime()));
        int affectedRows = ps.executeUpdate();
        long generatedId = 0;

        if (affectedRows == 0) {
            throw new SQLException("no rows affected");
        } else {
            System.out.println("Affected Rows = " + affectedRows + " rows");
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                    System.out.println("Generated ID = " + generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        ps.close();
        return generatedId;
    }
}

class SelectPemilikKucing {
    public static List<Kucing> initProcess(Connection conn, Statement stmt) throws SQLException {
        String sqlJinak;
        String sqlLiar;
        String sqlJinakLiar;

        sqlJinak = "select * from pemilik_kucing where is_liar = 0;";
        sqlLiar = "select * from pemilik_kucing where is_liar = 1;";
        sqlJinakLiar = "select * from pemilik_kucing;";

        List<Kucing> kucingJinakList = coreProcess(stmt, sqlJinak);
        List<Kucing> kucingLiarList = coreProcess(stmt, sqlLiar);
        List<Kucing> allKucingList = coreProcess(stmt, sqlJinakLiar);

        stmt.close();
        conn.close();

        return allKucingList;
    }

    public static List<Kucing> coreProcess(Statement stmt, String sql) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);

        List<Kucing> kucingList = new ArrayList<>();

        while (rs.next()) {
            Kucing kucing = new Kucing();
            kucing.setNama(rs.getString("nama"));
            kucing.setJenis(rs.getString("jenis"));
            if (rs.getByte("is_liar") == 0) {
                kucing.setLiar(false);
            } else {
                kucing.setLiar(true);
            }
            kucing.setTanggalLahir(rs.getDate("tanggal_lahir"));
            kucingList.add(kucing);
        }

        rs.close();
        return kucingList;
    }
}