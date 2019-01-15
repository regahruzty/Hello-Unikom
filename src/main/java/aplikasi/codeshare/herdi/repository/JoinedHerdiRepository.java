package main.java.aplikasi.codeshare.herdi.repository;

import main.java.aplikasi.codeshare.herdi.model.JoinedHerdi;

import java.sql.SQLException;

public interface JoinedHerdiRepository extends BaseRepository<JoinedHerdi,Long> {

public void deleteByIdBurungIdJenisIdSifat(Integer id_burung, Integer id_jenis, Integer id_sifat) throws SQLException;
}
