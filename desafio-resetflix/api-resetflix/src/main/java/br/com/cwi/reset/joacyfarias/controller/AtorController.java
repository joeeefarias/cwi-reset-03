package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/atores")

public class AtorController {

    @Autowired
    private AtorService atorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ator crirarAtor(@RequestBody Ator ator) throws Exception {
        atorService.criarAtor(ator);
        return ator;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaTodosOsAtores() throws Exception {
        return this.atorService.consultaAtores();
    }

    @GetMapping("/{em_atividade}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaAtoresEmatividade() throws Exception {
        return this.atorService.listarAtoresEmAtividade();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultaAtor(@PathVariable Integer id) throws Exception {
        return this.atorService.consultaAtor(id);
    }


}
