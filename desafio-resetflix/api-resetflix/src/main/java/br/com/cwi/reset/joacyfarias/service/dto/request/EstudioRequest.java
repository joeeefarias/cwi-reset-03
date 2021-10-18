package br.com.cwi.reset.joacyfarias.service.dto.request;

import br.com.cwi.reset.joacyfarias.enumeration.StatusAtividade;

import java.time.LocalDate;

public class EstudioRequest {

    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    private StatusAtividade statusAtividade;

    public EstudioRequest(Integer id, String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}


