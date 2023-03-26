package com.academia.academiadigitalmiromar.service;

import java.util.List;

import com.academia.academiadigitalmiromar.model.Matricula;
import com.academia.academiadigitalmiromar.model.dto.MatriculaDTO;

public interface MatriculaService {

    Matricula createMatricula(MatriculaDTO dto);

    Matricula getMatricula(Long id);

    List<Matricula> getAllMatricula(String bairro);

    void deleteMatricula(Long id);
    
}
