package br.com.cwi.reset.joacyfarias.exceptions;

import java.time.LocalDate;

public class NascimentoInvalidoException extends Exception{
    public NascimentoInvalidoException(LocalDate message){
        super(String.format("Não é possível cadastrar atores não nascidos", message));
    }
}
