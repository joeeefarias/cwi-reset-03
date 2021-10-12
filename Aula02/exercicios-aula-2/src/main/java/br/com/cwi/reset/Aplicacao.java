package br.com.cwi.reset;

import br.com.cwi.reset.enumeration.Genero;
import br.com.cwi.reset.exceptions.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.model.Ator;
import br.com.cwi.reset.model.Diretor;
import br.com.cwi.reset.model.Filme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args){

        Diretor dFincher = new Diretor("David Fincher", LocalDate.of(1962, 8,
                28), Genero.MASCULINO, 49);
        Ator jLi = new Ator("Jet Li", LocalDate.of(1963, 4, 26),
                Genero.MASCULINO, 3);
//
//        jLi.informacoes();
//        jLi.calcularIdade();
//        dFincher.informacoes();
//        dFincher.calcularIdade();
//
//
        Filme fightClub = null;
        try {
            fightClub = new Filme("Fight Club", "Muito interessante", 90, 1999,
                    1, dFincher);
        } catch (AvaliacaoForaDoPadraoException e) {
            e.printStackTrace();
        }
//
//        Filme se7en = new Filme("Se7en", "Tenso!", 86, 1995,
//                6, dFincher);
//
        fightClub.reproduzir();
//        se7en.reproduzir();





            List<Filme> filmes = new ArrayList<>();

        Filme filme01 = null;
        try {
            filme01 = new Filme("Um", "Bom", 90,
                    1990, 2, dFincher);
        } catch (AvaliacaoForaDoPadraoException e) {
            e.printStackTrace();
        }
        Filme filme02 = null;
        try {
            filme02 = new Filme("Dois", "Legal", 120,
                        19911, 3, dFincher);
        } catch (AvaliacaoForaDoPadraoException e) {
            e.printStackTrace();
        }
        Filme filme03 = null;
        try {
            filme03 = new Filme("Três", "Muito bom", 85,
                        1992, 4, dFincher);
        } catch (AvaliacaoForaDoPadraoException e) {
            e.printStackTrace();
        }
        Filme filme04 = null;
        try {
            filme04 = new Filme("Quatro", "Ótimo", 88,
                        1993, 4, dFincher);
        } catch (AvaliacaoForaDoPadraoException e) {
            e.printStackTrace();
        }

        filmes.add(filme01);
            filmes.add(filme02);
            filmes.add(filme03);
            filmes.add(filme04);

        for (Filme filme: filmes) {
            filme.reproduzir();
        }
//
//        filmes.forEach(Filme::reproduzir);

        }


}

