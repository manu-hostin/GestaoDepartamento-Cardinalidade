package com.senai.gestaoDepartamento.service;

import com.senai.gestaoDepartamento.DTO.DepartamentoRequisicao;
import com.senai.gestaoDepartamento.DTO.DepartamentoResposta;
import com.senai.gestaoDepartamento.mapper.DepartamentoMapper;
import com.senai.gestaoDepartamento.mapper.FuncionarioMapper;
import com.senai.gestaoDepartamento.model.Departamento;
import com.senai.gestaoDepartamento.repository.DepartamentoRepository;
import com.senai.gestaoDepartamento.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoResposta criarDepartamento (DepartamentoRequisicao requisicao) {
        Departamento departamento = new Departamento();
        departamento = mapper.paraEntidade(requisicao);
        Departamento salvo = repository.save(departamento);

        return mapper.paraResposta(salvo);
    }

    public List<DepartamentoResposta> listarDepartamentos () {
        List<Departamento> departamentos = repository.findAll();
        List<DepartamentoResposta> departamentoRespostas = new ArrayList<>();

        for (Departamento depto : departamentos) {
            departamentoRespostas.add(mapper.paraResposta(depto));
        }
        return departamentoRespostas;
    }

    public DepartamentoResposta buscarDepartamento (Long id) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não existe"));

        return mapper.paraResposta(departamento);
    }


}
