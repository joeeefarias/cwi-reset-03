package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import br.com.cwi.reset.joacyfarias.service.dto.request.AtorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/atores")

public class AtorController {

    private AtorService atorService;

    public AtorController() throws Exception{
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crirarAtor(@RequestBody AtorRequest atorRequest) throws Exception{
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaTodosOsAtores() throws Exception{
        return atorService.consultaAtores();
    }

    @GetMapping("/{EM_ATIVIDADE}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> listaAtoresEmatividade()throws Exception{
        return atorService.listarAtoresEmAtividade();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultaAtor(@PathVariable Integer id)throws Exception{
        return atorService.consultaAtor(id);
    }







//    @PutMapping

}
