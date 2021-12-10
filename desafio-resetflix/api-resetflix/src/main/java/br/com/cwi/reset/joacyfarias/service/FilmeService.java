package br.com.cwi.reset.joacyfarias.service;

import br.com.cwi.reset.joacyfarias.domain.Filme;
import br.com.cwi.reset.joacyfarias.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AtorService atorService;

    @Autowired
    private EstudioService estudioService;


    public Filme criarFilme() {


    }
}
