package br.com.cwi.reset.joacyfarias.service.dto.request;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.Tipoatuacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemAtorRequest {

    @NotNull(message = "Campo id é obrigatório")
    private Integer idAtor;

    @NotNull(message = "Campo ator é obrigatório")
    private Ator ator;

    @NotNull(message = "Campo nome personagem é obrigatório")
    private String nomePersonagem;

    @NotNull(message = "Campo descrção é obrigatório")
    private String descricaoPersonagem;

    @NotNull(message = "Campo tipo atuação é obrigatório")
    private Tipoatuacao tipoatuacao;
}
