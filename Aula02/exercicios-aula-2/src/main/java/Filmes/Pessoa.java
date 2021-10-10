package Filmes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void calcularIdade(){
        Long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        System.out.println("A idade de " + nome + " é: " + idade);
    }

    public void informacoes(){
        System.out.println("");
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Gênero: " + genero);

    }
}
