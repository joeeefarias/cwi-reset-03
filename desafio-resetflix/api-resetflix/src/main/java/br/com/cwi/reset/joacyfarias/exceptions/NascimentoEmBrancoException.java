package br.com.cwi.reset.joacyfarias.exceptions;

public class NascimentoEmBrancoException extends CampoInvalidoException {
    public NascimentoEmBrancoException() {
        super("dataNascimento");
    }
}
