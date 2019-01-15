package main.java.finalproject.repository;

import main.java.finalproject.model.Ekosistem;

import java.sql.SQLException;

public interface EkosistemRepository extends BaseRepository<Ekosistem, Long> {

    public void deleteByIdHewanAndIdTumbuhan(Long idHewan, Long idTumbuhan) throws SQLException;

}
