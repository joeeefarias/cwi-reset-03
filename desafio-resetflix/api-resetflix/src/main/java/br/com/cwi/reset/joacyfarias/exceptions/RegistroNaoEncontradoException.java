package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegistroNaoEncontradoException extends Exception {
    public RegistroNaoEncontradoException(String type, Integer id) {
        super(String.format("Nenhum %s encontrado com o parametro id=%d, verifique os parâmetros informados", type, id));
    }
}
