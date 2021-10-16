package br.com.cwi.reset.joacyfarias.exceptions;

import java.time.LocalDate;

public class InicioAtividadeException extends Exception{
    public InicioAtividadeException(LocalDate message) {
        super(String.format("Ano de inicio inválido para o %s cadastrado", message));
    }
}
