package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Estudio;
import br.com.cwi.reset.joacyfarias.enumeration.TipoDominio;
import br.com.cwi.reset.joacyfarias.exceptions.*;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.dto.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstudioService {

    public FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase){
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception{
        validaEstudio(estudioRequest);

        if(estudioRequest.getStatusAtividade() == null){
            throw new StatusAtividadeInvalidoException();
        }

        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudiocadastrado : estudiosCadastrados){
            if (estudiocadastrado.getNome().equalsIgnoreCase(estudiocadastrado.getNome())){
                throw new NomeDuplicadoException(TipoDominio.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        if (estudioRequest.getDataCriacao().isAfter(LocalDate.now())){
            throw new InicioAtividadeException(estudioRequest.getDataCriacao());
        }

        Estudio estudio = new Estudio(gerarId(), estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(estudio);

    }

    private void validaEstudio(EstudioRequest estudioRequest) throws Exception {
        if (estudioRequest.getNome() == null || estudioRequest.getNome().isEmpty()){
            throw new NomeInvalidoException();
        }
        if (estudioRequest.getDataCriacao().isAfter(LocalDate.now())) {
            throw new InicioAtividadeException(estudioRequest.getDataCriacao());
        }
        if (estudioRequest.getDataCriacao() == null) {
            throw new InicioAtividadeEmBrancoException();
        }

        for (Estudio estudio : fakeDatabase.recuperaEstudios()){
            if (estudio.getNome().equals(estudioRequest.getNome())){
                throw new NomeDuplicadoException(TipoDominio.ESTUDIO.getSingular(), estudioRequest.getNome());
            }

        }

    }

    public List<Estudio> ListaEstudios(final String filtroNome) throws Exception {
        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();
        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominio.ESTUDIO.getSingular(), TipoDominio.ESTUDIO.getPlural());
        }

        final List<Estudio> lista = new ArrayList<>();

        if (filtroNome != null){
            for (Estudio estudio : estudiosCadastrados){
                final boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT)
                        .contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter){
                    lista.add(estudio);
                }
            }
        }else {
            lista.addAll(estudiosCadastrados);
        }
        if (lista.isEmpty()){
            throw new FiltroNomeNaoEncontrado("Estudio", filtroNome);
        }
        return lista;
    }

    private Integer gerarId(){
        Integer id = 0;
        for (Estudio estudio: fakeDatabase.recuperaEstudios()){
            if (estudio.getId() > id){
                id = estudio.getId();
            }
        }
        return id + 1;
    }

}
