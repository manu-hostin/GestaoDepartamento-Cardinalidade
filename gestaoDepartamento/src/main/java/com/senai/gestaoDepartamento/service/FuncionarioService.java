package com.senai.gestaoDepartamento.service;

import com.senai.gestaoDepartamento.DTO.FuncionarioRequisicao;
import com.senai.gestaoDepartamento.DTO.FuncionarioResposta;
import com.senai.gestaoDepartamento.mapper.FuncionarioMapper;
import com.senai.gestaoDepartamento.model.Departamento;
import com.senai.gestaoDepartamento.model.Funcionario;
import com.senai.gestaoDepartamento.repository.DepartamentoRepository;
import com.senai.gestaoDepartamento.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;
    private final DepartamentoRepository departamentoRepository;

    public FuncionarioResposta cadastrarFuncionario (FuncionarioRequisicao requisicao) {
        Funcionario funcionario = new Funcionario();

        Departamento departamento = departamentoRepository.findById(requisicao.id_departamento())
                .orElseThrow(() -> new RuntimeException("Departamento não existe"));

        funcionario = mapper.paraEntidade(requisicao);
        funcionario.setDepartamento(departamento);

        Funcionario salvo = repository.save(funcionario);

        return mapper.paraResposta(salvo);
    }

    public List<FuncionarioResposta> listarFuncionarios () {
        List<Funcionario> funcionarios = repository.findAll();
        List<FuncionarioResposta> funcionarioRespostas = new ArrayList<>();

        for (Funcionario func : funcionarios){
            funcionarioRespostas.add(mapper.paraResposta(func));
        }

        return funcionarioRespostas;
    }

    public FuncionarioResposta buscarFuncionario (Long id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não existe!"));

        return mapper.paraResposta(funcionario);

    }

    // Filtro customizado
    public FuncionarioResposta findByIdDeptoAndNome (Long idDepto, String nome) {
        Funcionario funcionario = repository.findByDepartamentoIdAndNome(idDepto, nome);
        return mapper.paraResposta(funcionario);

    }

    public FuncionarioResposta findByIdAndNome (Long id, String nome) {
        Funcionario funcionario = repository.findByIdAndNome(id, nome);
        return mapper.paraResposta(funcionario);
    }


}
