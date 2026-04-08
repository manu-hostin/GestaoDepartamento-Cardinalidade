package com.senai.gestaoDepartamento.controller;

import com.senai.gestaoDepartamento.DTO.DepartamentoRequisicao;
import com.senai.gestaoDepartamento.DTO.DepartamentoResposta;
import com.senai.gestaoDepartamento.repository.DepartamentoRepository;
import com.senai.gestaoDepartamento.service.DepartamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoResposta> cadastrarDepartamento (@Valid @RequestBody DepartamentoRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarDepartamento(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResposta>> listarDepartamentos () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarDepartamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResposta> listarDepartamento (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarDepartamento(id));
    }


}
