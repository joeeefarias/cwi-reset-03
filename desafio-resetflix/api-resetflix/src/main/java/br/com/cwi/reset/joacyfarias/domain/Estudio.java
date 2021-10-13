package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.StatusAtividade;

public class Estudio {

    private Integer id;
    private String nome;
    private String descricao;
    private StatusAtividade statusAtividade;

    public Estudio(Integer id, String nome, String descricao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.statusAtividade = statusAtividade;
    }
}
