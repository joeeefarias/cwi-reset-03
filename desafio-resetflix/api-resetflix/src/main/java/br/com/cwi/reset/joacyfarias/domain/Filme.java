package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private LocalDate anoLancamento;
    private String capaFilme;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genero> generos;
    @ManyToOne
    @JoinColumn(name = "id_estudio")
    private Estudio estudio;
    @ManyToOne
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;
    @OneToMany
    @JoinColumn(name = "id_filme")
    private List<PersonagemAtor> personagens;
    private String resumo;


}
