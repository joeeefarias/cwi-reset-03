package Filmes;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor dFincher = new Diretor("David Fincher", 51, Genero.MASCULINO,49);
        Ator jli = new  Ator("Jet Li", 58,Genero.MASCULINO, 3);

        jli.informacoes();
        dFincher.informacoes();



//      Filme fightClub = new Filme("Fight Club", "Muito interessante", 90, 1999,
//              4,diretor);
//
//
//
//        Filme totoro = new Filme("Se7en", "Tenso!",86, 1995,
//                5, diretor);
//
//        fightClub.reproduzir();
//        totoro.reproduzir();


    }
}
