package br.gov.sp.fatec.springtopicos20242.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springtopicos20242.service.AlertaService;

import br.gov.sp.fatec.springtopicos20242.entity.Alerta;

@RestController
@RequestMapping(value = "/alerta")
@CrossOrigin
public class AlertaController {
    
    @Autowired
    private AlertaService service;

    @GetMapping(value = "listar")
    public List<Alerta> todosAlertas() {
        return service.todosAlertas();
    }

    @PostMapping(value = "cadastrar")
    public Alerta cadastrar(@RequestBody Alerta alerta){
        return service.novoAlerta(alerta);
    }

    @GetMapping(value="listarBy")
    public List<Alerta> listarBy(@RequestParam LocalDateTime dataHora, @RequestParam Integer nivel){
        return service.buscarPorDataHoraGeracaoAndNivel(dataHora, nivel);
    }

}
