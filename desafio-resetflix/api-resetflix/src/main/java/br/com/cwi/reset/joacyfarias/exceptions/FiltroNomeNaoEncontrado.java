package br.com.cwi.reset.joacyfarias.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNomeNaoEncontrado extends RuntimeException {
    public FiltroNomeNaoEncontrado(String tipo, String nome) {
        super(String.format("%s não encontrado com o filtro %s, favor informar outro filtro,", tipo, nome));
    }
}
