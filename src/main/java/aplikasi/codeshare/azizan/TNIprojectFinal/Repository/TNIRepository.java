package main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Repository;

import main.java.aplikasi.codeshare.azizan.TNIprojectFinal.Model.TNI;

import java.sql.SQLException;

public interface TNIRepository extends BaseRepository<TNI, Long> {

    public void deleteByIdTentaraAndIdTentaraAktifAndIdBatalyon(Long idTentara, Long idTentaraAktif, Long idBatalyon) throws SQLException;

}
