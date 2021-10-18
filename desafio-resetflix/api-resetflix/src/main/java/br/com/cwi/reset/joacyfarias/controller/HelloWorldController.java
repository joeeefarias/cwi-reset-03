package br.com.cwi.reset.joacyfarias.controller;

import br.com.cwi.reset.joacyfarias.exceptions.NomeInvalidoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")

public class HelloWorldController {

    @GetMapping

    public String helloWorld() throws Exception{

        throw new NomeInvalidoException();
//        return "Testando Funcionamento da API resetflix";
    }

}
