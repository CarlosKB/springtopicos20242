package br.gov.sp.fatec.springtopicos20242.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springtopicos20242.entity.Trabalho;
import br.gov.sp.fatec.springtopicos20242.repository.TrabalhoRepository;
import jakarta.transaction.Transactional;

@Service
public class TrabalhoServiceImpl implements TrabalhoService {
    
    private TrabalhoRepository repo;

    public TrabalhoServiceImpl(TrabalhoRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Trabalho novoTrabalho(Trabalho trabalho) {
        if(trabalho == null ||
                trabalho.getTitulo() == null ||
                trabalho.getGrupo() == null
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Titulo ou descrição inválidos!");
        }
        if(trabalho.getDataHora() == null){
            trabalho.setDataHora(LocalDateTime.now());
        }
        return repo.save(trabalho);
    }

    public List<Trabalho> todosTrabalhos() {
        List<Trabalho> trabalhos = new ArrayList<Trabalho>();
        for(Trabalho trabalho: repo.findAll()) {
            trabalhos.add(trabalho);
        }
        return trabalhos;
    }

    public List<Trabalho> buscarPeloTituloAndNota(String titulo, Integer nota){
        List<Trabalho> trabalhos = new ArrayList<Trabalho>();

        trabalhos = repo.buscarPorTituloAndNota(titulo, nota);

        return trabalhos;
    }

}
