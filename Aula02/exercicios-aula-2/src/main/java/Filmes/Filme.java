package Filmes;

public class Filme {

    private String nome;
    private int duracaoMinutos;
    private int anoDeLacamento;
    private int avaliacao;
    private String diretor;

    public Filme(String nome, int duracaoMinutos, int anoDeLacamento, int avaliacao, String diretor) {
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
        this.anoDeLacamento = anoDeLacamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Apresentando o filme");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Duração: " + this.getDuracaoMinutos());
        System.out.println("Ano de lançamento: " + this.getAnoDeLacamento());
        System.out.println("Avaliação: " + this.getAvaliacao());
        System.out.println("Diretor: " + this.getDiretor());
        System.out.println("");
        System.out.println("----------------------------------");
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getAnoDeLacamento() {
        return anoDeLacamento;
    }

    public void setAnoDeLacamento(int anoDeLacamento) {
        this.anoDeLacamento = anoDeLacamento;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
