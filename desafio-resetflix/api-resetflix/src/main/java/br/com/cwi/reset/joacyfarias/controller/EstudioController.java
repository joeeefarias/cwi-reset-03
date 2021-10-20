package br.com.cwi.reset.joacyfarias.controller;


import br.com.cwi.reset.joacyfarias.domain.Estudio;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.EstudioService;
import br.com.cwi.reset.joacyfarias.service.dto.request.EstudioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() throws Exception{
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception{
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarTodos() throws Exception{
        return FakeDatabase.getInstance().recuperaEstudios();
    }



}
