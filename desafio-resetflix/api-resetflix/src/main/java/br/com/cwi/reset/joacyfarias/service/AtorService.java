package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.exceptions.NegocioException;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;

import java.time.LocalDate;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }


    public void criarAtor(AtorRequest atorRequest) throws NegocioException {
        validaAtor(atorRequest);
        Ator ator = new Ator(gerarId(), atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);
    }



    private void validaAtor(AtorRequest atorRequest) throws NegocioException {
        if (atorRequest.getNome().equals(null) || atorRequest.getNome().isEmpty()){
            throw new NegocioException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }
        if (atorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new NegocioException("Não é possível cadastrar atores não nascidos.");
        }
        if (atorRequest.getAnoInicioAtividade().isBefore(atorRequest.getDataNascimento())) {
            throw new NegocioException("Ano de início de atividade inválido para o ator cadastrado.");
        }
        if (atorRequest.getAnoInicioAtividade().equals(null)) {
            throw new NegocioException("Campo Ano de inicio de carreira é obrigatório");
        }


    }

    private Integer gerarId(){
        Integer id = 0;
        for (Ator ator: fakeDatabase.recuperaAtores()){
            if (ator.getId() > id){
                id = ator.getId();
            }
        }
        return id + 1;
    }
}