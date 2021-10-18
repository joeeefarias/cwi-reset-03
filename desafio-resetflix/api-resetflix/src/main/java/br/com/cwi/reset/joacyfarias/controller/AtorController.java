package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.repository.FakeDatabase;
import br.com.cwi.reset.joacyfarias.service.AtorService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/atores")

public class AtorController {

    private AtorService atorService;

    public AtorController() throws Exception{
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

//    @PostMapping
//
//    @GetMapping
//
//    @PutMapping
//
//    @DeleteMapping
}
