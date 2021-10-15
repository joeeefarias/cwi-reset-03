package br.com.cwi.reset.joacyfarias.exceptions;

public class NascimentoInvalidoException extends CampoInvalidoException{
    public NascimentoInvalidoException(){
        super("Data de nascimento");
    }
}
