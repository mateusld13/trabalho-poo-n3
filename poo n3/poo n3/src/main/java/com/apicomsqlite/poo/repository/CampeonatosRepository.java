package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Campeonatos;

@Repository
public interface CampeonatosRepository extends JpaRepository<Campeonatos, Integer> {

    public boolean existsById(int id);

    public List<Campeonatos> findById(int id);

    @Query("select max(s.id) from Campeonatos s")
    public Integer findMaxId();
}