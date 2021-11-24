package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
    public void atualizarAtor(@PathVariable @RequestBody @Valid Integer id,  AtorRequest atorRequest) throws Exception{
        this.atorService.atualizarAtor(id, atorRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Ator> listaTodosOsAtores(@ApiIgnore
                                         @PageableDefault (sort = "nome", direction = Sort.Direction.ASC)
                                         Pageable pageable){
        return atorService.consultarAtores(pageable);
    }

    @GetMapping("/em-atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaAtoresEmatividade(){
        return this.atorService.listarAtoresEmAtividade();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultaAtor(@PathVariable Integer id){
        return this.atorService.consultarAtor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator removerAtor(@PathVariable Integer id){
        return this.atorService.removerAtor(id);
    }



}
