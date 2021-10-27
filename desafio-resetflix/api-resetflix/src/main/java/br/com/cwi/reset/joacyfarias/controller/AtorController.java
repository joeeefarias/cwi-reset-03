package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/atores")

public class AtorController {

    @Autowired
    private AtorService atorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crirarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception{
        this.atorService.atualizarAtor(atorRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaTodosOsAtores() throws Exception {
        return this.atorService.consultarAtores();
    }

    @GetMapping("/em-atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaAtoresEmatividade() throws Exception {
        return this.atorService.listarAtoresEmAtividade();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultaAtor(@PathVariable @Valid Integer id) throws Exception {
        return this.atorService.consultarAtor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator removerAtor(@PathVariable @Valid Integer id) throws Exception {
        return this.atorService.removerAtor(id);
    }



}
