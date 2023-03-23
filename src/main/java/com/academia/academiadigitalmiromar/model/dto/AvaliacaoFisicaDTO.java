package com.academia.academiadigitalmiromar.model.dto;

import java.time.LocalDateTime;

import com.academia.academiadigitalmiromar.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaDTO {

    private Aluno aluno;

    private double peso;

    private double altura;
    
}
