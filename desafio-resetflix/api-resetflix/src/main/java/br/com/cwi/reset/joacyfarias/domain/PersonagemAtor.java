package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.Tipoatuacao;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class PersonagemAtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_ator")
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    @Enumerated(EnumType.STRING)
    private Tipoatuacao tipoatuacao;

    public PersonagemAtor() {

    }

    public PersonagemAtor(Ator ator, String nomePersonagem, String descricaoPersonagem, Tipoatuacao tipoatuacao) {

        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoatuacao = tipoatuacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public void setDescricaoPersonagem(String descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }

    public Tipoatuacao getTipoatuacao() {
        return tipoatuacao;
    }

    public void setTipoatuacao(Tipoatuacao tipoatuacao) {
        this.tipoatuacao = tipoatuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonagemAtor that = (PersonagemAtor) o;
        return Objects.equals(id, that.id) && Objects.equals(nomePersonagem, that.nomePersonagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePersonagem);
    }
}
