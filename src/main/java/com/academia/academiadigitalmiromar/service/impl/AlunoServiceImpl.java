package com.academia.academiadigitalmiromar.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AlunoDTO;
import com.academia.academiadigitalmiromar.model.dto.AlunoUpdateDTO;
import com.academia.academiadigitalmiromar.repository.AlunoRepository;
import com.academia.academiadigitalmiromar.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alRepository;

    @Override
    public Aluno createAluno(AlunoDTO dto) {

        if(alRepository.findByCpf(dto.getCpf()).isPresent()){
        throw  new ResponseStatusException(HttpStatus.CONFLICT,
        "Erro Duplicidade\n CPF já cadastrado: " + dto.getCpf());
        }

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf().replaceAll("\\D", ""));
        aluno.setBairro(dto.getBairro());
        aluno.setDataDeNascimento(dto.getDataDeNascimento());

        return alRepository.save(aluno);

    }

    @Override
    public Aluno getAluno(Long id) {
        return alRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Aluno não encontrado com o ID: " + id));

    }

    @Override
    public List<Aluno> getAllAluno(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return alRepository.findAll();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dataDeNascimento, formatter);
            return alRepository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno updateAluno(Long id, AlunoUpdateDTO dto) {
        Aluno aluno =  alRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + id));       
        
       
        aluno.setBairro(dto.getBairro());
        aluno.setDataDeNascimento(dto.getDataDeNascimento());
        aluno.setNome(dto.getNome());
        return alRepository.save(aluno);

    }

    @Override
    public void deleteAluno(Long id) {
         alRepository.deleteById(id);
    }

    @Override

    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = alRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Aluno não encontrado com o ID: " + id));

        return aluno.getAvaliacoes();
    }

    @Override
    public Aluno getAlunoCpf(String cpf) {
     return alRepository.findByCpf(cpf).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
      "Aluno não encontrado com o CPF: " + cpf));
    
    }

}
