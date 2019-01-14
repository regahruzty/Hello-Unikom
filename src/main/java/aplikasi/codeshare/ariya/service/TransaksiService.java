package main.java.aplikasi.codeshare.ariya.service;

import main.java.aplikasi.codeshare.ariya.model.*;
import main.java.aplikasi.codeshare.ariya.repository.TransaksiRepository;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiService implements TransaksiRepository {

    private DataSource ds;

    public TransaksiService(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Transaksi> selectTransaksi() throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        List<Transaksi> transaksiList = SelectTransaksi.initProcess(conn, stmt);
        return transaksiList;
    }

    @Override
    public Transaksi save(Transaksi value) throws SQLException {
        Connection conn = ds.getConnection();
        long generatedValue = Save.initProcess(conn, value);
        value.setId_transaksi((int) generatedValue);
        return value;
    }

    @Override
    public Transaksi update(Transaksi value) throws SQLException {
        return null;
    }

    @Override
    public List<Transaksi> findAll() throws SQLException {
        return null;
    }

    @Override
    public Transaksi findOne(Integer id) throws SQLException {
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

class Save {
    public static long initProcess(Connection conn, Transaksi value) throws SQLException {
        String sql;

        sql = "INSERT INTO transaksi (id_pembeli, id_motor, tanggal_pembelian, jumlah_pembelian) VALUES (?, ?, ?, ?)";

        long generatedId = coreProcess(conn, sql, value);
        return generatedId;
    }

    public static long coreProcess(Connection conn, String sql, Transaksi value) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, value.getId_pembeli());
        ps.setInt(2, value.getId_motor());
        ps.setString(3, value.getTanggal_pembelian());
        ps.setInt(4, value.getJumlah_pembelian());
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



class SelectTransaksi {
    public static List<Transaksi> initProcess(Connection conn, Statement stmt) throws SQLException {
        String sqlTransaksi;


        sqlTransaksi = "select * from transaksi;";


        List<Transaksi> allTransaksiList = coreProcess(stmt, sqlTransaksi);

        stmt.close();
        conn.close();

        return allTransaksiList;
    }

    public static List<Transaksi> coreProcess(Statement stmt, String sql) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);

        List<Transaksi> transaksiList = new ArrayList<>();

        while (rs.next()) {
            Transaksi transaksi = new Transaksi();
            Motor motor = new Motor();
            Pembeli pembeli = new Pembeli();
            transaksi.setId_transaksi(rs.getInt("id_transaksi"));
            motor.setMerk_motor(rs.getString("merk_motor"));
            motor.setNama_motor(rs.getString("nama_motor"));
            motor.setHarga(rs.getInt("harga"));
            pembeli.setNama_pembeli(rs.getString("nama_pembeli"));
            transaksi.setJumlah_pembelian(rs.getInt("jumlah_pembelian"));
            transaksi.setTanggal_pembelian(rs.getString("tanggal_pembelian"));
            transaksi.setId_motor(motor.getId_motor());
            transaksi.setId_pembeli(pembeli.getId_pembeli());

            transaksiList.add(transaksi);
        }

        rs.close();
        return transaksiList;
    }
}