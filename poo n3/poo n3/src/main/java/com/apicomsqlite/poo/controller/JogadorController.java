package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.apicomsqlite.poo.enity.Jogador;
import com.apicomsqlite.poo.service.JogadorService;

@RestController
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @RequestMapping(value = "jogador", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createJogador", method = RequestMethod.POST)
    public String createJogador(@RequestBody Jogador jogador) {
        return jogadorService.createJogador(jogador);
    }

    @RequestMapping(value = "readJogador", method = RequestMethod.GET)
    public List<Jogador> readJogador() {
        return jogadorService.readJogador();
    }

    @RequestMapping(value = "updateJogador", method = RequestMethod.PUT)
    public String updateJogador(@RequestBody Jogador jogador) {
        return jogadorService.updateJogador(jogador);
    }

    @RequestMapping(value = "deleteJogador", method = RequestMethod.DELETE)
    public String deleteJogador(@RequestBody Jogador jogador) {
        return jogadorService.deleteJogador(jogador);
    }
}
