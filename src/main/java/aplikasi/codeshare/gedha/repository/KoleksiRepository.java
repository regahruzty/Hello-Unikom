package main.java.aplikasi.codeshare.gedha.repository;

//import main.java.aplikasi.codeshare.gedha.model.Buku;
import main.java.aplikasi.codeshare.gedha.model.Koleksi;

import java.sql.SQLException;
import java.util.List;
/**
 * @param <T> Model class
 * @param <E> Primary key
 **/

public interface KoleksiRepository<T,E> {
    public T save(T value) throws SQLException;
    public T update(T value) throws SQLException;
    public List<T> findAll() throws SQLException;
    public  Boolean exists(E id) throws SQLException;
    public void delete(E id) throws SQLException;
    //public void deleteByIdBukuAndIdKomikAndIdMajalah(Long idBuku, Long idKomik, Long idMajalah) throws SQLException;
}
