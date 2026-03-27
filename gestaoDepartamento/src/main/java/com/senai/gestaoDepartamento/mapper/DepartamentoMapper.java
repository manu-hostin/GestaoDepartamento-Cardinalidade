package com.senai.gestaoDepartamento.mapper;

import com.senai.gestaoDepartamento.DTO.DepartamentoRequisicao;
import com.senai.gestaoDepartamento.DTO.DepartamentoResposta;
import com.senai.gestaoDepartamento.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento paraEntidade (DepartamentoRequisicao requisicao) {
        return new Departamento(
                requisicao.nome()
        );
    }

    public DepartamentoResposta paraResposta (Departamento departamento) {
        return new DepartamentoResposta(
                departamento.getId(),
                departamento.getNome()
        );
    }
}
