package com.academia.academiadigitalmiromar.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academia.academiadigitalmiromar.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, Long>{

   List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);

}
