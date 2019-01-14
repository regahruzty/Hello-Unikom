package main.java.aplikasi.repository;

import main.java.aplikasi.model.Kucing;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author regahruzty
 */
public interface KucingRepository extends BaseRepository<Kucing, Integer> {

    public List<Kucing> selectPemilikKucing() throws SQLException;
    public List<Kucing> selectPemilikKucingLiar() throws SQLException;

}