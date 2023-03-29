package com.academia.academiadigitalmiromar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.Matricula;
import com.academia.academiadigitalmiromar.model.dto.MatriculaDTO;
import com.academia.academiadigitalmiromar.repository.AlunoRepository;
import com.academia.academiadigitalmiromar.repository.MatriculaRepository;
import com.academia.academiadigitalmiromar.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    @Autowired
    private AlunoRepository alRepository;
    @Autowired
    private MatriculaRepository matRepository;

    @Override
    public Matricula createMatricula(MatriculaDTO dto) {

        Matricula matricula = new Matricula();
        Aluno aluno = alRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Aluno não encontrado com o ID: " + dto.getAlunoId()));
        matricula.setAluno(aluno);
        return matRepository.save(matricula);

    }

    @Override
    public Matricula getMatricula(Long id) {
        return matRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Matricula não encontrado com o ID: " + id));

    }

    @Override
    public List<Matricula> getAllMatricula(String bairro) {
        if (bairro == null) {
            return matRepository.findAll();
        } else {
            return matRepository.findByAlunoBairro(bairro);
        }

    }

    @Override
    public void deleteMatricula(Long id) {
        matRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Matricula não encontrado com o ID: " + id));
                        System.out.println("Delete nao chegou aqui");
        matRepository.deleteById(id);
    }

}
