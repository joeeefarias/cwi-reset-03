package br.com.cwi.reset.joacyfarias.controller;


import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.service.DiretorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Diretor> listaDiretores(@ApiIgnore
                                        @PageableDefault(sort = "nome", direction = Sort.Direction.ASC)
                                                    Pageable pageable, @RequestParam(name = "nome", required = false)
                                        String nome){
        return diretorService.listarDiretores(nome, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Diretor cadastraDiretor(@RequestBody @Valid DiretorRequest diretorRequest) {
        return diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultaDiretor(@PathVariable Integer id){
        return diretorService.consultarDiretor(id);
    }

}
