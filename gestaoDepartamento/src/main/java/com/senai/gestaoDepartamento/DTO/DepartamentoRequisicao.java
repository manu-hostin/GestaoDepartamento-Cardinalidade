package com.senai.gestaoDepartamento.DTO;

import jakarta.validation.constraints.NotNull;

public record DepartamentoRequisicao(

        @NotNull
        String nome

) {
}
