package com.academia.academiadigitalmiromar.service;

import java.util.List;

import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AvaliacaoFisicaDTO;
import com.academia.academiadigitalmiromar.model.dto.AvaliacaoFisicaUpdateDTO;

public interface AvaliacaoFisicaService {

    AvaliacaoFisica createAvaliacaoFisica(AvaliacaoFisicaDTO dto);

    AvaliacaoFisica getAvaliacaoFisica(Long id);

    List<AvaliacaoFisica> getAllAvaliacaoFisica();

    AvaliacaoFisica updateAvaliacaoFisica(Long id, AvaliacaoFisicaUpdateDTO dto);

    void deleteAvaliacaoFisica(Long id);
    
}
