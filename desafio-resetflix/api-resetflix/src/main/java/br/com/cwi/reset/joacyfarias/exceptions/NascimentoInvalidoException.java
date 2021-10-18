package br.com.cwi.reset.joacyfarias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NascimentoInvalidoException extends Exception{
    public NascimentoInvalidoException(LocalDate message){
        super(String.format("Não é possível cadastrar atores não nascidos", message));
    }
}
