package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Estudio;
import br.com.cwi.reset.joacyfarias.service.EstudioService;
import br.com.cwi.reset.joacyfarias.service.dto.request.EstudioRequest;
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
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudio criarEstudio(@RequestBody @Valid EstudioRequest estudio){
        return estudioService.criarEstudio(estudio);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Estudio>consultarEstudios(@ApiIgnore
                                          @PageableDefault(sort = "nome", direction = Sort.Direction.ASC)
                                          Pageable pageable,
                                          @RequestParam(name = "nome", required = false)
                                          String nome){
        return estudioService.consultarEstudios(nome, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultaEstudio(@PathVariable Integer id){
        return estudioService.consultaEstudio(id);
    }
}
