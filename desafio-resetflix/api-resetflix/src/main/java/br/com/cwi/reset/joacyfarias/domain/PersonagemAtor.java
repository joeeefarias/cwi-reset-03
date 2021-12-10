package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.Tipoatuacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}
