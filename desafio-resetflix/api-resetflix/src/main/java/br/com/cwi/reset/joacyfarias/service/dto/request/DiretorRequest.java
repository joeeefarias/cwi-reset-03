package br.com.cwi.reset.joacyfarias.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiretorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo data de nascimento")
    @Past(message = "Não é possível cadastrar atores não nascidos")
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome")
    private LocalDate anoInicioAtividade;
}
