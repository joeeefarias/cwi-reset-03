package br.com.cwi.reset.joacyfarias.service.dto.request;

import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;

import javax.validation.constraints.*;
import java.time.LocalDate;

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

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira,
                       LocalDate anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public LocalDate getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
