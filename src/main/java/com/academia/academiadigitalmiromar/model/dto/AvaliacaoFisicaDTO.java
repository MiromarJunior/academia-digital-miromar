package com.academia.academiadigitalmiromar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaDTO {

    private Long alunoId;

    private double peso;

    private double altura;
    
}
