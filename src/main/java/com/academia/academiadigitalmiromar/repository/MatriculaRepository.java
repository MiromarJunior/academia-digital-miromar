package com.academia.academiadigitalmiromar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academia.academiadigitalmiromar.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    // @Query("FROM Matricula m WHERE m.aluno.bairro = :bairro")
    // @Query(value = """
    //             SELECT a.*, m.id as mat_id, m.data_da_matricula, m.aluno_id  FROM tb_matriculas m
    //              JOIN tb_alunos a on m.aluno_id = a.id
    //              where a.bairro = :bairro
    //                 """, nativeQuery = true)

    // List<Matricula> buscaBairro(String bairro);

     List<Matricula> findByAlunoBairro(String bairro);

}
