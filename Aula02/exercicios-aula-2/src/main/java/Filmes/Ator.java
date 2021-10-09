package Filmes;

public class Ator extends Pessoa{

    Integer qtdOscar;


    public Ator(String nome, Integer idade, Genero genero, Integer qdtOscar) {
        super(nome, idade, genero);
        this.qtdOscar = qdtOscar;
    }

    public void informacoes(){
        super.informacoes();
        System.out.println("Quantidade de Oscars: " + qtdOscar);
    }
}
