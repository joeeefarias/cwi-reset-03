package br.com.cwi.reset.model;

import br.com.cwi.reset.exceptions.AvaliacaoForaDoPadraoException;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracaoMinutos;
    private Integer anoDeLacamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracaoMinutos, Integer anoDeLacamento, Integer avaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        if (avaliacao <1 || avaliacao >5){
            throw new AvaliacaoForaDoPadraoException();
        }
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.anoDeLacamento = anoDeLacamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }





    public void reproduzir() {

        System.out.println("Apresentando o filme");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracaoMinutos);
        System.out.println("Ano de lançamento: " + anoDeLacamento);
        System.out.println("Avaliação: " + avaliacao);
        System.out.println("Diretor: " + diretor.getNome());
        System.out.println("");
        System.out.println("----------------------------------");

    }

    public Integer getAvaliacao() {
        return avaliacao;
    }
}

