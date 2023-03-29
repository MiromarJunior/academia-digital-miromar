package com.academia.academiadigitalmiromar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.academia.academiadigitalmiromar.model.Matricula;
import com.academia.academiadigitalmiromar.model.dto.MatriculaDTO;
import com.academia.academiadigitalmiromar.service.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public ResponseEntity<Matricula> createMatricula(@RequestBody MatriculaDTO dto){
        Matricula matricula = service.createMatricula(dto);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(matricula.getId())
        .toUri();
        return  ResponseEntity.created(uri).body(matricula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatriculaId(@PathVariable Long id){
        Matricula matricula = service.getMatricula(id);
        return ResponseEntity.ok().body(matricula);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAllMatricula(@RequestParam(value = "bairro", required = false)String bairro){
        List<Matricula> matricula = service.getAllMatricula(bairro);
        return ResponseEntity.ok().body(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatricula(@PathVariable Long id){
        service.deleteMatricula(id);
        String msg = "Matricula e ALuno exluídos com sucesso";
        return ResponseEntity.ok().body(msg);
    }
    
}
