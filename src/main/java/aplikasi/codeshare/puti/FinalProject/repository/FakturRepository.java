package main.java.aplikasi.codeshare.puti.FinalProject.repository;

import main.java.aplikasi.codeshare.puti.FinalProject.model.Faktur;

import java.sql.SQLException;

public interface FakturRepository  extends BaseRepository<Faktur, Long>{
    public void deleteByIdBarangAndIdPembeli(Long idBarang, Long idPembeli) throws SQLException;
}
