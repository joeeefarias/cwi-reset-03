package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Estudio;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.ListaVaziaException;
import br.com.cwi.reset.joacyfarias.exceptions.NomeDuplicadoException;
import br.com.cwi.reset.joacyfarias.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.reset.joacyfarias.repository.EstudioRepository;
import br.com.cwi.reset.joacyfarias.service.dto.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository repository;

    public Estudio criarEstudio(EstudioRequest estudioRequest) {
        validaNomeEstudio(estudioRequest);

        Estudio estudio = Estudio.builder()
                .nome(estudioRequest.getNome())
                .descricao(estudioRequest.getDescricao())
                .dataCriacao(estudioRequest.getDataCriacao())
                .statusAtividade(estudioRequest.getStatusAtividade())
                .build();

        return repository.save(estudio);
    }

    private void validaNomeEstudio(EstudioRequest estudioRequest){
        for (Estudio estudio: repository.findAll()) {
            if (estudio.getNome().equalsIgnoreCase(estudioRequest.getNome())){
                throw new NomeDuplicadoException(TipoDominio.ESTUDIO.getSingular(), TipoDominio.ESTUDIO.getPlural());
            }
        }
    }

    public Page<Estudio> consultarEstudios(String nome, Pageable pageable) {
        Page<Estudio> estudios = repository.findAll(pageable);
        if (estudios.getTotalElements() == 0) {
            throw new ListaVaziaException(TipoDominio.ESTUDIO.getSingular(), TipoDominio.ESTUDIO.getPlural());
        }

        if (nome != null && !nome.isEmpty()) {
            return repository.findAllByNomeContainsIgnoreCase(nome, pageable);
        } else {
            return estudios;
        }
    }

    public Estudio consultaEstudio(Integer id){
        return repository.findById(id).orElseThrow(() ->
                new RegistroNaoEncontradoException(TipoDominio.ESTUDIO.getSingular(), id));
    }
}
