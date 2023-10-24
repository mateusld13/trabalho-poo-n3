package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Campeonatos;
import com.apicomsqlite.poo.repository.CampeonatosRepository;

import jakarta.transaction.Transactional;

@Service
public class CampeonatosService {

    @Autowired(required = false)
    private CampeonatosRepository campeonatosRepository;

    @Transactional

    public String createCampeonato(Campeonatos campeonato) {
        try {
            if (!campeonatosRepository.existsById(campeonato.getId())) {
                campeonato.setId(null == campeonatosRepository.findMaxId() ? 1 : campeonatosRepository.findMaxId() + 1);
                campeonatosRepository.save(campeonato);

                return "campeonato cadastrada com sucesso.";
            } else {
                return "campeonato já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Campeonatos> readCampeonato() {
        return campeonatosRepository.findAll();
    }

    @Transactional
    public String updateCampeonato(Campeonatos campeonatos) {
        if (campeonatosRepository.existsById(campeonatos.getId())) {
            try {
                List<Campeonatos> campeonatoss = campeonatosRepository.findById(campeonatos.getId());
                for (Campeonatos campeonatosToBeUpdate : campeonatoss) {
                    campeonatosToBeUpdate.setTipo(campeonatos.getTipo());
                    campeonatosToBeUpdate.setCategoria(campeonatos.getCategoria());

                    campeonatosRepository.save(campeonatosToBeUpdate);
                }
                return "Campeonatos atualizada.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Campeonatos não existe no banco.";
        }
    }

    @Transactional
    public String deleteCampeonato(Campeonatos Campeonato) {
        if (campeonatosRepository.existsById(Campeonato.getId())) {
            try {
                List<Campeonatos> Campeonatos = campeonatosRepository.findById(Campeonato.getId());
                Campeonatos.stream().forEach(s -> {
                    campeonatosRepository.delete(s);
                });
                return "Campeonato deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Campeonato n\u00E3o existe no banco.";
        }
    }
}
