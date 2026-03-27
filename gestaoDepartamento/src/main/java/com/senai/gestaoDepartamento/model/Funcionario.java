package com.senai.gestaoDepartamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double salario;

    @ManyToOne
    private Departamento departamento;

    public Funcionario(String nome, Double salario, Long id_departamento) {
        this.nome = nome;
        this.salario = salario;
    }
}
