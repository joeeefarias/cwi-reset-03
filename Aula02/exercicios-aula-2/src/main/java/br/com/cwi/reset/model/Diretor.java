package br.com.cwi.reset.model;

import br.com.cwi.reset.enumeration.Genero;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private Integer quantidadeFilmes;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, Integer quantidadeFilmes) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }


    public void informacoes() {
        super.informacoes();
        System.out.println("Quantidade de Filmes: " + quantidadeFilmes);
    }


}
