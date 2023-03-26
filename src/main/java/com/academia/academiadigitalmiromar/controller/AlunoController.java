package com.academia.academiadigitalmiromar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AlunoDTO;
import com.academia.academiadigitalmiromar.model.dto.AlunoUpdateDTO;
import com.academia.academiadigitalmiromar.service.impl.AlunoServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento ) {
        List<Aluno> alunos = alService.getAllAluno(dataDeNascimento);
        return new ResponseEntity<>(alunos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoId(@PathVariable Long id){
        Aluno aluno = alService.getAluno(id);
        return ResponseEntity.ok(aluno);
    }

  




    @PostMapping
    public ResponseEntity<Aluno> createAluno( @Valid @RequestBody AlunoDTO dto){
      Aluno aluno =   alService.createAluno(dto);
      URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(aluno.getId())
        .toUri();
      return  ResponseEntity.created(uri).body(aluno);
      

    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno( @PathVariable Long id, @RequestBody AlunoUpdateDTO dto){   
       Aluno aluno =   alService.updateAluno(id ,dto);
      return  ResponseEntity.ok().body(aluno);    

    }




    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisica>> getAllAvalicaoFisicaId(@PathVariable Long id) {
        List<AvaliacaoFisica> avaliacao = alService.getAllAvaliacaoFisicaId(id);
        return new ResponseEntity<>(avaliacao,HttpStatus.OK);
    }

}
