package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeInvalidoException extends CampoInvalidoException{
    public NomeInvalidoException(){
        super("nome");
    }
}