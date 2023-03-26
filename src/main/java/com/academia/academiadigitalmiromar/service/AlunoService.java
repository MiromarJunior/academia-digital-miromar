package com.academia.academiadigitalmiromar.service;

import java.util.List;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AlunoDTO;
import com.academia.academiadigitalmiromar.model.dto.AlunoUpdateDTO;

public interface AlunoService {

    Aluno createAluno(AlunoDTO dto);

    Aluno getAluno(Long id);

    List<Aluno> getAllAluno(String dataDeNascimento);

    Aluno updateAluno(Long id,AlunoUpdateDTO dto);

    void deleteAluno(Long id);

    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);

    
    
}
