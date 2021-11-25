package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoInvalidoException extends RuntimeException{

    public CampoInvalidoException(final String campo) {
        super(String.format("Campo obrigatório não informado. Favor informar o campo %s", campo));
    }
}
