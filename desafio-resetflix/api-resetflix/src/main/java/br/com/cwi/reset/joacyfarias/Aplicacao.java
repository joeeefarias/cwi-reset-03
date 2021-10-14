package br.com.cwi.reset.joacyfarias;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.exceptions.NegocioException;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws NegocioException {


        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        LocalDate anoInicioAtividade = LocalDate.of(1986, 10, 12);
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        AtorRequest keanuReeves = new AtorRequest("Keanu Reeves", LocalDate.of(1964, 9, 02),
                StatusCarreira.APOSENTADO, LocalDate.of(1986, 1, 01));

        AtorRequest jonBernthal = new AtorRequest("Jon Bernthal", LocalDate.of(1976, 9, 20),
                StatusCarreira.EM_ATIVIDADE, LocalDate.of(1986, 1, 01));


        atorService.criarAtor(atorRequest);
        atorService.criarAtor(keanuReeves);
        atorService.criarAtor(jonBernthal);



        List<Ator> atoresEmAtividade = atorService.listarAtoresEmAtividade();
        for (Ator ator: atoresEmAtividade) {
            System.out.println("ID: " + ator.getId() + " - " + ator.getNome() + " nascido em :  "
                    + ator.getDataNascimento());
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

    }
}
