package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.integration.AvatarService;
import br.com.cwi.reset.joacyfarias.repository.AtorRepository;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    AvatarService avatarService;


    public Ator criarAtor(AtorRequest atorRequest) throws Exception {
        validaAtor(atorRequest);

        Ator ator = Ator.builder()
                .nome(atorRequest.getNome())
                .dataNascimento(atorRequest.getDataNascimento())
                .statusCarreira(atorRequest.getStatusCarreira())
                .anoInicioAtividade(atorRequest.getAnoInicioAtividade())
                .avatarUrl(avatarService.buscarAvatarAtor().getLink()).build();

        return repository.save(ator);
    }


    private void validaAtor(AtorRequest atorRequest) throws Exception {

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new NomeESobreNomeException(TipoDominio.ATOR.getSingular());
        }

        if (atorRequest.getAnoInicioAtividade().isBefore(atorRequest.getDataNascimento())) {
            throw new InicioAtividadeException(atorRequest.getAnoInicioAtividade());
        }

        for (Ator ator : repository.findAll()) {
            if (ator.getNome().equals(atorRequest.getNome())) {
                throw new NomeDuplicadoException(TipoDominio.ATOR.getSingular(), atorRequest.getNome());
            }

        }

    }

    public List<Ator> listarAtoresEmAtividade() throws Exception {
        List<Ator> atoresEmAtividade = new ArrayList<>();
        for (Ator ator : repository.findAll()) {
            if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                atoresEmAtividade.add(ator);

            }
            if (atoresEmAtividade.isEmpty()) {
                throw new FiltroInvalidoException();
            }
        }
        return atoresEmAtividade;
    }

    public List<Ator> consultarAtores() throws Exception {
        if (repository.findAll().isEmpty()) {
            throw new ListaVaziaException(TipoDominio.ATOR.getSingular(), TipoDominio.ATOR.getPlural());
        }
        return repository.findAll();
    }


      /* Implementantdo métodos mais simples */
    public Ator consultarAtor(Integer id) throws Exception {

        return repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));

    }


    public Ator removerAtor(Integer id){
        Ator ator = repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));
        repository.deleteById(id);
        return ator;

    }


    public void atualizarAtor(Integer id, AtorRequest atorRequest) throws Exception {

        Ator ator = repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));
        ator.setNome(atorRequest.getNome());
        ator.setDataNascimento(atorRequest.getDataNascimento());
        ator.setStatusCarreira(atorRequest.getStatusCarreira());
        ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());

        repository.save(ator);

    }
}