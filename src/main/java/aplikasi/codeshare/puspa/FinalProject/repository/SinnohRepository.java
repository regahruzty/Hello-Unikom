package main.java.aplikasi.codeshare.puspa.FinalProject.repository;

import main.java.aplikasi.codeshare.puspa.FinalProject.model.Sinnoh;

import java.sql.SQLException;

public interface SinnohRepository extends BaseRepository<Sinnoh, Long>{

        public void deleteByIdFireAndIdWater(Long idFire, Long idWater) throws SQLException;

    }
