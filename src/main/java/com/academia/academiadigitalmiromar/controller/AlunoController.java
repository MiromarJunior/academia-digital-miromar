package com.academia.academiadigitalmiromar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AlunoDTO;
import com.academia.academiadigitalmiromar.service.impl.AlunoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno() {
        List<Aluno> alunos = alService.getAllAluno();
        return new ResponseEntity<>(alunos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody AlunoDTO dto){
      Aluno aluno =   alService.createAluno(dto);
      return new ResponseEntity<>(aluno,HttpStatus.CREATED);
      

    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisica>> getAllAvalicaoFisicaId(@PathVariable Long id) {
        List<AvaliacaoFisica> avaliacao = alService.getAllAvaliacaoFisicaId(id);
        return new ResponseEntity<>(avaliacao,HttpStatus.OK);
    }

}
