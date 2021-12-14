package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Filme;
import br.com.cwi.reset.joacyfarias.service.FilmeService;
import br.com.cwi.reset.joacyfarias.service.dto.request.FilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Filme criarfilme(@RequestBody @Valid FilmeRequest filmeRequest){
//        return filmeService.criarFilme();
//    }
}
