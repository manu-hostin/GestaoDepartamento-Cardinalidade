package com.senai.gestaoDepartamento.DTO;

public record FuncionarioResposta(

        Long id,
        String nome,
        Double salario,

        Long id_departamento

) {
}
