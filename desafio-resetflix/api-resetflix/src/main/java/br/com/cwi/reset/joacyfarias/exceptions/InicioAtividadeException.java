package br.com.cwi.reset.joacyfarias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InicioAtividadeException extends Exception{
    public InicioAtividadeException(LocalDate message) {
        super(String.format("Ano de inicio inválido para o %s cadastrado", message));
    }
}
