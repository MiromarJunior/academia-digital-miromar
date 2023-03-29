package com.academia.academiadigitalmiromar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AvaliacaoFisicaDTO;
import com.academia.academiadigitalmiromar.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    private AvaliacaoFisicaServiceImpl avService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> createAvaliacao(@RequestBody AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica avaliacao = avService.createAvaliacaoFisica(dto);        
        return new ResponseEntity<>(avaliacao, HttpStatus.CREATED);
    }
    
    
}
