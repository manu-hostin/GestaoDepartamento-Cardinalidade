package com.senai.gestaoDepartamento.repository;

import com.senai.gestaoDepartamento.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByDepartamentoIdAndNome(Long idDepartamento, String nome);

    Funcionario findByIdAndNome (Long id, String nome);
}
