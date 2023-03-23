package com.academia.academiadigitalmiromar.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    
    private String nome;

    private String cpf;

    private String bairro;

    private LocalDate dataDeNascimento;

    
}
