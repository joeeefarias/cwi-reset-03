package br.com.cwi.reset.joacyfarias.exceptions;

public class NomeDuplicadoException extends Exception {
    public NomeDuplicadoException(String nome) {
        super(String.format("Já existe um ator cadastrado com o nome %s", nome));
    }
}
