package br.com.cwi.reset.joacyfarias.service.dto.request;

import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.domain.Estudio;
import br.com.cwi.reset.joacyfarias.domain.PersonagemAtor;
import br.com.cwi.reset.joacyfarias.enumeration.Genero;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeRequest {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String nome;
    private LocalDate anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Estudio estudio;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;
}
