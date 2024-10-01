package br.gov.sp.fatec.springtopicos20242.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springtopicos20242.entity.Trabalho;


public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    
    @Query("select t from Trabalho t where t.titulo LIKE %?1% AND t.nota > ?2 ")
    public List<Trabalho> buscarPorTituloAndNota(String titulo, Integer nota);
    
}