package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.repository.DiretorRepository;
import br.com.cwi.reset.joacyfarias.service.dto.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;


    public void cadastrarDiretor(final DiretorRequest diretorRequest) throws Exception {
        validaDiretor(diretorRequest);

        final List<Diretor> diretoresCadastrados = (List<Diretor>) repository.findAll();

        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getNome().equalsIgnoreCase(diretorRequest.getNome())) {
                throw new NomeDuplicadoException(TipoDominio.DIRETOR.getSingular(), diretorRequest.getNome());
            }
        }

        final Diretor diretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade());

        repository.save(diretor);
    }

    private void validaDiretor(DiretorRequest diretorRequest) throws Exception {

        if (diretorRequest.getNome().split(" ").length < 2){
            throw new NomeESobreNomeException(TipoDominio.ATOR.getSingular());
        }

        if (diretorRequest.getAnoInicioAtividade().isBefore(diretorRequest.getDataNascimento())) {
            throw new InicioAtividadeException(diretorRequest.getAnoInicioAtividade());
        }
        for (Diretor diretor : repository.findAll()){
            if (diretor.getNome().equals(diretorRequest.getNome())){
                throw new NomeDuplicadoException(TipoDominio.DIRETOR.getSingular(), diretorRequest.getNome());
            }

        }

    }

    public List<Diretor> listarDiretores(final String filtroNome) throws Exception {
        final List<Diretor> diretoresCadastrados = (List<Diretor>) repository.findAll();

        if (diretoresCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominio.DIRETOR.getSingular(), TipoDominio.DIRETOR.getPlural());
        }

        final List<Diretor> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Diretor diretor : diretoresCadastrados) {
                final boolean containsFilter = diretor.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(diretor);
                }
            }
        } else {
            retorno.addAll(diretoresCadastrados);
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Diretor", filtroNome);
        }

        return retorno;
    }

    public Diretor consultarDiretor(final Integer id) throws Exception {
        if (id == null) {
            throw new RegistroNaoEncontradoException(TipoDominio.DIRETOR.getSingular(), id);
        }

        final List<Diretor> diretores = (List<Diretor>) this.repository.findAll();

        for (Diretor diretor : diretores) {
            if (diretor.getId().equals(id)) {
                return diretor;
            }
        }

        throw new RegistroNaoEncontradoException(TipoDominio.DIRETOR.getSingular(), id);
    }
}
