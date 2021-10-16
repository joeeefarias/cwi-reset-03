package br.com.cwi.reset.joacyfarias.exceptions;

public class FiltroInvalidoException extends Exception{
    public FiltroInvalidoException() {
        super("Nenhum ator encontrado para o parâmetro: Em atividade");
    }
}
