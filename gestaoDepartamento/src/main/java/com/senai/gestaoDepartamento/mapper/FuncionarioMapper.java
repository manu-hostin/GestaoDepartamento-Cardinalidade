package com.senai.gestaoDepartamento.mapper;

import com.senai.gestaoDepartamento.DTO.FuncionarioRequisicao;
import com.senai.gestaoDepartamento.DTO.FuncionarioResposta;
import com.senai.gestaoDepartamento.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario paraEntidade (FuncionarioRequisicao requisicao) {
        return new Funcionario(
                requisicao.nome(),
                requisicao.salario(),
                requisicao.id_departamento()
        );
    }

    public FuncionarioResposta paraResposta (Funcionario funcionario) {
        return new FuncionarioResposta(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getSalario(),
                funcionario.getDepartamento().getId()
        );
    }
}
