package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeDuplicadoException extends Exception {
    public NomeDuplicadoException(String tipo, String nome) {
        super(String.format("Já existe um %s cadastrado com o nome %s",tipo, nome));
    }
}
