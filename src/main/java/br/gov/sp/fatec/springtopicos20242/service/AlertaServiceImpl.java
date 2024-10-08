package br.gov.sp.fatec.springtopicos20242.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springtopicos20242.entity.Alerta;
import br.gov.sp.fatec.springtopicos20242.repository.AlertaRepository;
import jakarta.transaction.Transactional;

@Service
public class AlertaServiceImpl implements AlertaService{
    
    private AlertaRepository repo;

    public AlertaServiceImpl(AlertaRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Alerta novoAlerta(Alerta Alerta) {
        if(Alerta == null 
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Alerta esta vazio!");
        }
        if(Alerta.getDataHoraGeracao() == null){
            Alerta.setDataHoraGeracao(LocalDateTime.now());
        }
        if(Alerta.getNivel() == null){
            Alerta.setNivel(5);
        }
        return repo.save(Alerta);
    }

    public List<Alerta> todosAlertas() {
        List<Alerta> Alertas = new ArrayList<Alerta>();
        for(Alerta Alerta: repo.findAll()) {
            Alertas.add(Alerta);
        }
        return Alertas;
    }

    public List<Alerta> buscarPorDataHoraGeracaoAndNivel(LocalDateTime dataHoraGeracao, Integer nivel){
        List<Alerta> Alertas = new ArrayList<Alerta>();

        Alertas = repo.buscarPorDataHoraGeracaoAndNivel(dataHoraGeracao, nivel);

        return Alertas;
    }

}
