package Filmes;

public class Ator {
    String nome;
    Integer idade;
    Integer oscarsVencidos;
    Genero genero;

    public Ator(String nome, Integer idade, Integer oscarsVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscarsVencidos = oscarsVencidos;
        this.genero = genero;
    }

    public void atorNomeIdadeGenero(){
        System.out.println("Nome; " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Gênero: " + genero.getDescricao());
    }
}
