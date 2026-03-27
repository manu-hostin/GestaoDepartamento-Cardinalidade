package com.senai.gestaoDepartamento.controller;

import com.senai.gestaoDepartamento.DTO.FuncionarioRequisicao;
import com.senai.gestaoDepartamento.DTO.FuncionarioResposta;
import com.senai.gestaoDepartamento.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public FuncionarioResposta cadastrarFuncionario (@Valid @RequestBody FuncionarioRequisicao requisicao) {
        return service.cadastrarFuncionario(requisicao);
    }

    @GetMapping("")
    public List<FuncionarioResposta> buscarFuncionarios () {
        return service.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public FuncionarioResposta buscarFuncionario (@PathVariable Long id) {
        return service.buscarFuncionario(id);
    }

}
