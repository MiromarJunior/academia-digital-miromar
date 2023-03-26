package com.academia.academiadigitalmiromar.model.dto;

import java.time.LocalDateTime;

import com.academia.academiadigitalmiromar.model.Aluno;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class MatriculaDTO {

    @NotNull(message ="Preencha o campo corretamente")
    @Positive(message = "O ID precisa ser positivo")
    private Long alunoId;

    
}
