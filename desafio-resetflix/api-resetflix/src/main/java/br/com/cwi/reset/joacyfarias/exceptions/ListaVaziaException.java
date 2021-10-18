package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaVaziaException extends Exception {
    public ListaVaziaException(String tipo, String plural){
        super(String.format("Nenhum %s cadastrado, é necessário cadastrar %s", tipo, plural));
    }
}
