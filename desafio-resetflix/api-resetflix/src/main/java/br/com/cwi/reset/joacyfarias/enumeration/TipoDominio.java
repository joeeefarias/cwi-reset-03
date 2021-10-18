package br.com.cwi.reset.joacyfarias.enumeration;

public enum TipoDominio {

    ATOR("ator", "atores"),
    DIRETOR("diretor", "Diretores"),
    ESTUDIO("estudio", "estudios");

    private final String singular;
    private final  String plural;

    TipoDominio(final String singular, final String plural){
        this.singular = singular;
        this.plural = plural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }
}
