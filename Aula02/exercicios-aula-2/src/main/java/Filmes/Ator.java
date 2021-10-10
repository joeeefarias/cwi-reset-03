package Filmes;

import java.time.LocalDate;

public class Ator extends Pessoa{

    Integer qtdOscar;


    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer qdtOscar) {
        super(nome, dataNascimento, genero);
        this.qtdOscar = qdtOscar;
    }

    public void informacoes(){
        super.informacoes();
        System.out.println("Quantidade de Oscars: " + qtdOscar);
    }
}
