package br.com.cwi.reset.joacyfarias.exceptions;

public class CampoInvalidoException extends Exception{

    public CampoInvalidoException(final String campo) {
        super(String.format("Campo obrigatório não informado. Favor informar o campo %s", campo));
    }
}
