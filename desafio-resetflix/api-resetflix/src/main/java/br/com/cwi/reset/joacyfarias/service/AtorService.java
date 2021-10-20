package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
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


    public void criarAtor(AtorRequest atorRequest) throws Exception {
        validaAtor(atorRequest);
        Ator ator = new Ator(gerarId(), atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);
    }



    private void validaAtor(AtorRequest atorRequest) throws Exception {
        if (atorRequest.getNome() == null || atorRequest.getNome().isEmpty()){
            throw new NomeInvalidoException();
        }
        if (atorRequest.getNome().split(" ").length < 2){
            throw new NomeESobreNomeException(TipoDominio.ATOR.getSingular());
        }

        if (atorRequest.getDataNascimento().isAfter(LocalDate.now())){
            throw new NascimentoInvalidoException(atorRequest.getDataNascimento());
        }
        if (atorRequest.getDataNascimento() == null){
            throw new NascimentoEmBrancoException();
        }
        if (atorRequest.getAnoInicioAtividade().isBefore(atorRequest.getDataNascimento())) {
            throw new InicioAtividadeException(atorRequest.getAnoInicioAtividade());
        }
        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new InicioAtividadeEmBrancoException();
        }

        for (Ator ator : fakeDatabase.recuperaAtores()){
            if (ator.getNome().equals(atorRequest.getNome())){
                throw new NomeDuplicadoException(TipoDominio.ATOR.getSingular(), atorRequest.getNome());
            }

        }

    }

    public List<Ator> listarAtoresEmAtividade() throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();
        for (Ator ator : fakeDatabase.recuperaAtores()) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                atoresEmAtividade.add(ator);

            }
            if (atoresEmAtividade.isEmpty()) {
                throw new FiltroInvalidoException();
            }
        }
        return atoresEmAtividade;
    }

    public List<Ator> consultaAtores()throws Exception{
        if (fakeDatabase.recuperaAtores().isEmpty()){
            throw new ListaVaziaException(TipoDominio.ATOR.getSingular(), TipoDominio.ATOR.getPlural());
        }
        return fakeDatabase.recuperaAtores();
    }

    public Ator consultaAtor(final Integer id)throws Exception{
        if(id == null ){
            throw new IdInvalidoException();
        }
        final List<Ator> atores = fakeDatabase.recuperaAtores();

        for (Ator ator : atores){
            if(ator.getId().equals(id)){
                return ator;
            }
        }
        throw new IdInvalidoException();
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