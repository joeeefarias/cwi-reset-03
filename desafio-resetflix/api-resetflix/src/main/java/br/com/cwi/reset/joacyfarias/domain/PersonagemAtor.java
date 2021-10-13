package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.Tipoatuacao;

public class PersonagemAtor {
    private Integer id;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private Tipoatuacao tipoatuacao;

    public PersonagemAtor(Integer id, Ator ator, String nomePersonagem, String descricaoPersonagem,
                          Tipoatuacao tipoatuacao) {
        this.id = id;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoatuacao = tipoatuacao;
    }
}
