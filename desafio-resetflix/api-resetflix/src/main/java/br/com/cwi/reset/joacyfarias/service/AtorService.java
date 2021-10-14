package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.exceptions.NegocioException;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
        if (atorRequest.getNome() == null || atorRequest.getNome().isEmpty()){
            throw new NegocioException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }
        if (atorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new NegocioException("Não é possível cadastrar atores não nascidos.");
        }
        if (atorRequest.getAnoInicioAtividade().isBefore(atorRequest.getDataNascimento())) {
            throw new NegocioException("Ano de início de atividade inválido para o ator cadastrado.");
        }
        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new NegocioException("Campo Ano de inicio de carreira é obrigatório");
        }

        for (Ator ator : fakeDatabase.recuperaAtores()){
            if (ator.getNome().equals(atorRequest.getNome())){
                throw new NegocioException("Já existe um ator cadastrado para o nome: " + atorRequest.getNome());
            }

        }

    }

    public List<Ator> listarAtoresEmAtividade() throws NegocioException {
        List<Ator> atoresEmAtividade = new ArrayList<>();
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                atoresEmAtividade.add(ator);

            }
            if (atoresEmAtividade.isEmpty()) {
                throw new NegocioException("Nenhum ator encontrado para o parâmetro: Em atividade");
            }
        }
        return atoresEmAtividade;
    }

//    {
//
//    }



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