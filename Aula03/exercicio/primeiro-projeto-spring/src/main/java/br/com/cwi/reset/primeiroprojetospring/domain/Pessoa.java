package br.com.cwi.reset.primeiroprojetospring.domain;



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

    private Long calcularIdade(){
        return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());

    }

    public void informacoes(){
        System.out.println("");
        System.out.println("Nome: " + nome);
        System.out.println("idade: " + this.calcularIdade());
        System.out.println("Gênero: " + genero);

    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }
}
