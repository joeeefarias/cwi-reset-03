package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NomeESobreNomeException extends CampoInvalidoException {
    public NomeESobreNomeException(final String message){
        super(String.format("Deve ser informado ao menos nome e sobrenome para o %s", message));
    }

}
