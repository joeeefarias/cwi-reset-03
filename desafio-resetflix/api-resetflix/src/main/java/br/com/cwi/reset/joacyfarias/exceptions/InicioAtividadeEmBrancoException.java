package br.com.cwi.reset.joacyfarias.exceptions;

public class InicioAtividadeEmBrancoException extends CampoInvalidoException {
    public InicioAtividadeEmBrancoException(){
        super("anoInicioAtividade");
    }
}
