package com.senai.gestaoDepartamento.controller;

import com.senai.gestaoDepartamento.DTO.DepartamentoRequisicao;
import com.senai.gestaoDepartamento.DTO.DepartamentoResposta;
import com.senai.gestaoDepartamento.repository.DepartamentoRepository;
import com.senai.gestaoDepartamento.service.DepartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public DepartamentoResposta cadastrarDepartamento (@Valid @RequestBody DepartamentoRequisicao requisicao) {
        return service.criarDepartamento(requisicao);
    }

    @GetMapping
    public List<DepartamentoResposta> listarDepartamentos () {
        return service.listarDepartamentos();
    }

    @GetMapping("/{id}")
    public DepartamentoResposta listarDepartamento (@PathVariable Long id) {
        return service.buscarDepartamento(id);
    }


}
