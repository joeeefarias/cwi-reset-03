package br.com.cwi.reset.joacyfarias.domain;

import java.time.LocalDate;

public class Diretor {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private LocalDate anoInicioAtividade;

    public Diretor(Integer id, String nome, LocalDate dataNascimento, LocalDate anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}