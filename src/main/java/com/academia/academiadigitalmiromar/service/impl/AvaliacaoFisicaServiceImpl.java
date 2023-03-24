package com.academia.academiadigitalmiromar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.academia.academiadigitalmiromar.model.Aluno;
import com.academia.academiadigitalmiromar.model.AvaliacaoFisica;
import com.academia.academiadigitalmiromar.model.dto.AvaliacaoFisicaDTO;
import com.academia.academiadigitalmiromar.model.dto.AvaliacaoFisicaUpdateDTO;
import com.academia.academiadigitalmiromar.repository.AlunoRepository;
import com.academia.academiadigitalmiromar.repository.AvaliacaoFisicaRepository;
import com.academia.academiadigitalmiromar.service.AvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl  implements AvaliacaoFisicaService{

    @Autowired
    private AvaliacaoFisicaRepository avRepository;

    @Autowired
    private AlunoRepository alRepository;

    @Override
    public AvaliacaoFisica createAvaliacaoFisica(AvaliacaoFisicaDTO dto) {
        AvaliacaoFisica avaliacao = new AvaliacaoFisica();
       Aluno aluno =  alRepository.findById(dto.getAlunoId())
       .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + dto.getAlunoId()));
       avaliacao.setAluno(aluno);
       avaliacao.setPeso(dto.getPeso());
       avaliacao.setAltura(dto.getAltura());
       
    return avRepository.save(avaliacao);
   
    }

    @Override
    public AvaliacaoFisica getAvaliacaoFisica(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAvaliacaoFisica'");
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisica() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAvaliacaoFisica'");
    }

    @Override
    public AvaliacaoFisica updateAvaliacaoFisica(Long id, AvaliacaoFisicaUpdateDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAvaliacaoFisica'");
    }

    @Override
    public void deleteAvaliacaoFisica(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAvaliacaoFisica'");
    }
    
}
