package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Time;
import com.apicomsqlite.poo.repository.TimeRepository;

import jakarta.transaction.Transactional;

@Service
public class TimeService {

    @Autowired(required = false)
    private TimeRepository timeRepository;

    @Transactional

    public String createTime(Time time) {
        try {
            if (!timeRepository.existsById(time.getId())) {
                time.setId(null == timeRepository.findMaxId() ? 1 : timeRepository.findMaxId() + 1);
                timeRepository.save(time);

                return "time cadastrada com sucesso.";
            } else {
                return "time já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Time> readTime() {
        return timeRepository.findAll();
    }

    @Transactional
    public String updateTime(Time time) {
        if (timeRepository.existsById(time.getId())) {
            try {
                List<Time> times = timeRepository.findById(time.getId());
                for (Time timeToBeUpdate : times) {
                    timeToBeUpdate.setNome(time.getNome());
                    timeToBeUpdate.setGoleiro(time.getGoleiro());
                    timeToBeUpdate.setZagueiro(time.getZagueiro());
                    timeToBeUpdate.setLateral(time.getLateral());
                    timeToBeUpdate.setVolante(time.getVolante());
                    timeToBeUpdate.setMeioAtacante(time.getMeioAtacante());
                    timeToBeUpdate.setMeioCampo(time.getMeioCampo());
                    timeToBeUpdate.setAtacante(time.getAtacante());
                    timeRepository.save(timeToBeUpdate);
                }
                return "time atualizada.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "time não existe no banco.";
        }
    }

    @Transactional
    public String deleteTime(Time Time) {
        if (timeRepository.existsById(Time.getId())) {
            try {
                List<Time> Times = timeRepository.findById(Time.getId());
                Times.stream().forEach(s -> {
                    timeRepository.delete(s);
                });
                return "Time deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Time n\u00E3o existe no banco.";
        }
    }
}
