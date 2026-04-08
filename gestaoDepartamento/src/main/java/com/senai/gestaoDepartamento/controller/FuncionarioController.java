package com.senai.gestaoDepartamento.controller;

import com.senai.gestaoDepartamento.DTO.FuncionarioRequisicao;
import com.senai.gestaoDepartamento.DTO.FuncionarioResposta;
import com.senai.gestaoDepartamento.model.Funcionario;
import com.senai.gestaoDepartamento.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioResposta> cadastrarFuncionario (@Valid @RequestBody FuncionarioRequisicao requisicao) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrarFuncionario(requisicao));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResposta>> buscarFuncionarios () {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResposta> buscarFuncionario (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarFuncionario(id));
    }

    @GetMapping("/busca")
    public ResponseEntity<FuncionarioResposta> buscarPorIdDptoNome (@RequestParam Long idDepto, @RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByIdDeptoAndNome(idDepto, nome));
    }

    @GetMapping("/buscaFunc")
    public ResponseEntity<FuncionarioResposta> buscarPorIdNome (@RequestParam Long id, @RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findByIdAndNome(id, nome));
    }
}
