package Filmes;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracaoMinutos;
    private Integer anoDeLacamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, Integer duracaoMinutos, Integer anoDeLacamento, Integer avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.anoDeLacamento = anoDeLacamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Apresentando o filme");
        System.out.println("Nome: " + nome);
        System.out.println("Duração: " + duracaoMinutos);
        System.out.println("Ano de lançamento: " + anoDeLacamento);
        System.out.println("Avaliação: " + avaliacao);
        System.out.println("Diretor: " + diretor);
        System.out.println("");
        System.out.println("----------------------------------");
    }

}

