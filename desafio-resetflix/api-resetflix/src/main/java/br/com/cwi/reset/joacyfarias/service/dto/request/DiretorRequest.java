package br.com.cwi.reset.joacyfarias.service.dto.request;

import java.time.LocalDate;

public class DiretorRequest {

    private String nome;
    private LocalDate dataNascimento;
    private LocalDate anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, LocalDate anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public LocalDate getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
