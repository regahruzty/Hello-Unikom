package main.java.aplikasi.codeshare.ariya.ariya_final.repository;


import main.java.aplikasi.codeshare.ariya.ariya_final.model.Transaksi;

import java.sql.SQLException;

public interface TransaksiRepository extends BaseRepository<Transaksi, Long> {
    public void deleteByIdMotorAndIdPembeli(Long id_motor, Long id_pembeli) throws SQLException;

}
