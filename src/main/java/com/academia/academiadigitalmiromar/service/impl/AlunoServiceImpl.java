package com.academia.academiadigitalmiromar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.dto.AlunoDTO;
import com.academia.academiadigitalmiromar.model.dto.AlunoUpdateDTO;
import com.academia.academiadigitalmiromar.repository.AlunoRepository;
import com.academia.academiadigitalmiromar.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository alRepository;

    @Override
    public Aluno createAluno(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setBairro(dto.getBairro());
        aluno.setDataDeNascimento(dto.getDataDeNascimento());

     return  alRepository.save(aluno);

    }

    @Override
    public Aluno getAluno(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAluno'");
    }

    @Override
    public List<Aluno> getAllAluno() {
      return  alRepository.findAll();
    }

    @Override
    public Aluno updateAluno(Long id, AlunoUpdateDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAluno'");
    }

    @Override
    public void deleteAluno(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAluno'");
    }

   

  
    
}
