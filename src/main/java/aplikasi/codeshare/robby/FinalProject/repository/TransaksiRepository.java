package main.java.aplikasi.codeshare.robby.FinalProject.repository;

import main.java.aplikasi.codeshare.robby.FinalProject.model.Transaksi;

import java.sql.SQLException;

public interface TransaksiRepository extends BaseRepository<Transaksi, Long> {
    public void deleteByIdKomputerDanPemilik(Long idKomputer, Long idPemilik) throws SQLException;
}
