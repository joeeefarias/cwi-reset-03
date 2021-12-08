package br.com.cwi.reset.joacyfarias.service.dto.request;

import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo data de nascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos")
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo status carreira")
    private StatusCarreira statusCarreira;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo ano de inicio de atividade")
    private LocalDate anoInicioAtividade;

}
