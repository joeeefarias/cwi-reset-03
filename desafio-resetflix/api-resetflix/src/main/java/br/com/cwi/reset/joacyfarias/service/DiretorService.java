package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.repository.DiretorRepository;
import br.com.cwi.reset.joacyfarias.service.dto.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;


    public Diretor cadastrarDiretor( DiretorRequest diretorRequest) {
        validaDiretor(diretorRequest);

        Diretor diretor = Diretor.builder()
                .nome(diretorRequest.getNome())
                .anoInicioAtividade(diretorRequest.getAnoInicioAtividade())
                .dataNascimento(diretorRequest.getDataNascimento()).build();

        return repository.save(diretor);
    }

    private void validaDiretor(DiretorRequest diretorRequest) {

        if (diretorRequest.getNome().split(" ").length < 2){
            throw new NomeESobreNomeException(TipoDominio.ATOR.getSingular());
        }

        if (diretorRequest.getAnoInicioAtividade().isBefore(diretorRequest.getDataNascimento())) {
            throw new InicioAtividadeException(diretorRequest.getAnoInicioAtividade());
        }
        for (Diretor diretor : repository.findAll()){
            if (diretor.getNome().equalsIgnoreCase(diretorRequest.getNome())){
                throw new NomeDuplicadoException(TipoDominio.DIRETOR.getSingular(), diretorRequest.getNome());
            }

        }

    }

    public Page<Diretor> listarDiretores(String nome, Pageable pageable) {

        if (nome != null && !nome.isEmpty()) {
            return repository.findAllByNomeEqualsIgnoreCase(nome, pageable);
        } else {
            return repository.findAll(pageable);

        }
    }

    public Diretor consultarDiretor(final Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.DIRETOR.getSingular(), id));
    }
}
