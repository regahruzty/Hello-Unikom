package main.java.aplikasi.repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author regahruzty
 * @param <T> Model class
 * @param <E> Primary key
 */
public interface KucingRepository<T, E> {

    public List<T> selectPemilikKucing() throws SQLException;
    public List<T> selectPemilikKucingLiar() throws SQLException;

}