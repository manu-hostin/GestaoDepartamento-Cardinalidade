package com.senai.gestaoDepartamento.DTO;

import com.senai.gestaoDepartamento.model.Departamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record FuncionarioRequisicao(

        @NotNull
        String nome,

        @PositiveOrZero
        Double salario,

        @PositiveOrZero
        Long id_departamento

) {
}
