package com.academia.academiadigitalmiromar.model.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    @NotBlank(message ="Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message ="Preencha o campo corretamente")
    @CPF(message = "'${validatedValue}' é inválido.")
    private String cpf;

    @NotBlank(message ="Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String bairro;

    @NotNull(message ="Preencha o campo corretamente")
    @Past(message = "Data '${validatedValue}' é inválida")
    private LocalDate dataDeNascimento;

    
}
