package br.com.cwi.reset.enumeration;

public enum Genero {

    MASCULINO("Masculino"),
    FEMINIBO("Feminino"),
    NAO_BINARIO("Não Binário");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
