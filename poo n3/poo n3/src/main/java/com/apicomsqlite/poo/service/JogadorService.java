package com.apicomsqlite.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.poo.enity.Jogador;
import com.apicomsqlite.poo.repository.JogadorRepository;

import jakarta.transaction.Transactional;

@Service
public class JogadorService {

    @Autowired(required = false)
    private JogadorRepository jogadorRepository;

    @Transactional

    public String createJogador(Jogador jogador) {
        try {
            if (!jogadorRepository.existsById(jogador.getId())) {
                jogador.setId(null == jogadorRepository.findMaxId() ? 1 : jogadorRepository.findMaxId() + 1);
                jogadorRepository.save(jogador);

                return "jogador cadastrada com sucesso.";
            } else {
                return "jogador já existe no banco.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Jogador> readJogador() {
        return jogadorRepository.findAll();
    }

    @Transactional
    public String updateJogador(Jogador jogador) {
        if (jogadorRepository.existsById(jogador.getId())) {
            try {
                List<Jogador> jogadors = jogadorRepository.findById(jogador.getId());
                for (Jogador jogadorToBeUpdate : jogadors) {
                    jogadorToBeUpdate.setNome(jogador.getNome());
                    jogadorToBeUpdate.setPosicao(jogador.getPosicao());
                    jogadorToBeUpdate.setIdade(jogador.getIdade());

                    jogadorRepository.save(jogadorToBeUpdate);
                }
                return "jogador atualizada.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "jogador não existe no banco.";
        }
    }

    @Transactional
    public String deleteJogador(Jogador jogador) {
        if (jogadorRepository.existsById(jogador.getId())) {
            try {
                List<Jogador> jogadors = jogadorRepository.findById(jogador.getId());
                jogadors.stream().forEach(s -> {
                    jogadorRepository.delete(s);
                });
                return "jogador deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "jogador n\u00E3o existe no banco.";
        }
    }
}
