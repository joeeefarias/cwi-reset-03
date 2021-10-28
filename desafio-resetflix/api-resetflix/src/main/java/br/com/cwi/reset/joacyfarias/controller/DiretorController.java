package br.com.cwi.reset.joacyfarias.controller;


import br.com.cwi.reset.joacyfarias.domain.Diretor;
import br.com.cwi.reset.joacyfarias.service.DiretorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listaDiretores(@RequestParam String filtoNome)throws Exception{
        return diretorService.listarDiretores(filtoNome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws Exception{
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

}
