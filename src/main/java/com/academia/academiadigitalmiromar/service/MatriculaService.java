package com.academia.academiadigitalmiromar.service;

import java.util.List;

import com.academia.academiadigitalmiromar.model.Matricula;
import com.academia.academiadigitalmiromar.model.dto.MatriculaDTO;

public interface MatriculaService {

    Matricula createMatricula(MatriculaDTO dto);

    Matricula geMatricula(Long id);

    List<Matricula> getAllMatricula();

    void deleteMatricula(Long id);
    
}
