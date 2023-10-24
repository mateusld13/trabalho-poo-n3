package com.apicomsqlite.poo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.poo.enity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {

    public boolean existsById(int id);

    public List<Time> findById(int id);

    @Query("select max(s.id) from Time s")
    public Integer findMaxId();
}