package Filmes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        Diretor dFincher = new Diretor("David Fincher", LocalDate.of(1962, 8,
                28), Genero.MASCULINO, 49);
//        Ator jli = new Ator("Jet Li", LocalDate.of(1963, 4, 26),
//                Genero.MASCULINO, 3);
//
//        jli.informacoes();
//        jli.calcularIdade();
//        dFincher.informacoes();
//        dFincher.calcularIdade();
//
//
//        Filme fightClub = new Filme("Fight Club", "Muito interessante", 90, 1999,
//                -1, dFincher);
//
//        Filme totoro = new Filme("Se7en", "Tenso!", 86, 1995,
//                6, dFincher);
//
//        fightClub.reproduzir();
//        totoro.reproduzir();

//        try {
//            fightClub.avaliar(-1);
//        } catch (AvaliacaoForaDoPadraoException e) {
//            e.printStackTrace();
//        }

        List<Filme> filmes = new ArrayList<>();

            Filme filme01 = new Filme("Um", "Bom", 90,
                    1990, 2, dFincher);
            Filme filme02 = new Filme("Dois", "Legal", 120,
                    19911, 3, dFincher);
            Filme filme03 = new Filme("Três", "Muito bom", 85,
                    1992, 4, dFincher);
            Filme filme04 = new Filme("Quatro", "Ótimo", 88,
                    1993, 4, dFincher);

            filmes.add(filme01);
            filmes.add(filme02);
            filmes.add(filme03);
            filmes.add(filme04);

            for (Filme f: filmes){
                System.out.println(f);
            }


    }
}

