package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    public boolean existsById(int id);

    public List<Jogador> findById(int id);

    @Query("select max(s.id) from Jogador s")
    public Integer findMaxId();
}