package br.gov.sp.fatec.springtopicos20242.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springtopicos20242.entity.Alerta;

public interface AlertaRepository extends JpaRepository<Alerta, Long>{
    
    @Query("select a from Alerta a where a.dataHoraGeracao > ?1 AND a.nivel < ?2 ")
    public List<Alerta> buscarPorDataHoraGeracaoAndNivel(LocalDateTime dataHoraGeracao, Integer nivel);

}
