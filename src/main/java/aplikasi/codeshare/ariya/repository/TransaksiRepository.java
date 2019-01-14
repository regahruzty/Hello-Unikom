package main.java.aplikasi.codeshare.ariya.repository;

import main.java.aplikasi.codeshare.ariya.model.*;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author regahruzty
 */
public interface TransaksiRepository extends BaseRepository<Transaksi, Integer> {

    public List<Transaksi> selectTransaksi() throws SQLException;

}