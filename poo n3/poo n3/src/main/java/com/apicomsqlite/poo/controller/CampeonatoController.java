package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Campeonatos;
import com.apicomsqlite.poo.service.CampeonatosService;

@RestController
public class CampeonatoController {

    @Autowired
    private CampeonatosService CampeonatoService;

    @RequestMapping(value = "campeonato", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createCampeonato", method = RequestMethod.POST)
    public String createCampeonato(@RequestBody Campeonatos campeonato) {
        return CampeonatoService.createCampeonato(campeonato);
    }

    @RequestMapping(value = "readCampeonato", method = RequestMethod.GET)
    public List<Campeonatos> readCampeonato() {
        return CampeonatoService.readCampeonato();
    }

    @RequestMapping(value = "updateCampeonato", method = RequestMethod.PUT)
    public String updateCampeonato(@RequestBody Campeonatos campeonato) {
        return CampeonatoService.updateCampeonato(campeonato);
    }

    @RequestMapping(value = "deleteCampeonato", method = RequestMethod.DELETE)
    public String deleteCampeonato(@RequestBody Campeonatos campeonato) {
        return CampeonatoService.deleteCampeonato(campeonato);
    }
}
