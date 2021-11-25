package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.integration.AvatarService;
import br.com.cwi.reset.joacyfarias.repository.AtorRepository;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    AvatarService avatarService;


    public Ator criarAtor(AtorRequest atorRequest){
        validaAtor(atorRequest);

        Ator ator = Ator.builder()
                .nome(atorRequest.getNome())
                .dataNascimento(atorRequest.getDataNascimento())
                .statusCarreira(atorRequest.getStatusCarreira())
                .anoInicioAtividade(atorRequest.getAnoInicioAtividade())
                .avatarUrl(avatarService.buscarAvatarAtor().getLink()).build();

        return repository.save(ator);
    }


    private void validaAtor(AtorRequest atorRequest){

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

    public Page<Ator> listarAtoresEmAtividade(String nome, Pageable pageable) {

        if (nome != null && !nome.isEmpty()) {
            return repository.findAllByStatusCarreiraAndNomeContainingIgnoreCase(
                    StatusCarreira.EM_ATIVIDADE, nome, pageable);
        } else {
            return repository.findAllByStatusCarreira(StatusCarreira.EM_ATIVIDADE, pageable);
        }

    }

    public Page<Ator> consultarAtores(Pageable pageable) {
        Page<Ator> atores = repository.findAll(pageable);
        if (atores.getTotalElements() == 0) {
            throw new ListaVaziaException(TipoDominio.ATOR.getSingular(), TipoDominio.ATOR.getPlural());
        }

        return atores;
    }


    /* Implementantdo métodos mais simples */
    public Ator consultarAtor(Integer id) {

        return repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));

    }


    public Ator removerAtor(Integer id) {
        Ator ator = repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));
        repository.deleteById(id);
        return ator;

    }


    public void atualizarAtor(Integer id, AtorRequest atorRequest) {

        Ator ator = repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ATOR.getSingular(), id));
        ator.setNome(atorRequest.getNome());
        ator.setDataNascimento(atorRequest.getDataNascimento());
        ator.setStatusCarreira(atorRequest.getStatusCarreira());
        ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());

        repository.save(ator);

    }
}