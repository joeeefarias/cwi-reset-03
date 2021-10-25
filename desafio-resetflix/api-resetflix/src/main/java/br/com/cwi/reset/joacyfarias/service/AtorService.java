package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;


    public void criarAtor(Ator ator) throws Exception {
        validaAtor(ator);
        repository.save(ator);
    }


    private void validaAtor(Ator atorRequest) throws Exception {

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new NomeESobreNomeException(TipoDominio.ATOR.getSingular());
        }

        if (atorRequest.getDataNascimento().isAfter(LocalDate.now())) {
            throw new NascimentoInvalidoException(atorRequest.getDataNascimento());
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

    public List<Ator> consultaAtores() throws Exception {
        if (repository.findAll().isEmpty()) {
            throw new ListaVaziaException(TipoDominio.ATOR.getSingular(), TipoDominio.ATOR.getPlural());
        }
        return repository.findAll();
    }

    public Ator consultaAtor(final Integer id) throws Exception {
        if (id == null) {
            throw new IdInvalidoException();
        }
        final List<Ator> atores = repository.findAll();

        for (Ator ator : atores) {
            if (ator.getId().equals(id)) {
                return ator;
            }
        }
        throw new IdInvalidoException();
    }


}