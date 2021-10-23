package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetCadastradoException;
import br.com.cwi.reset.projeto1.exception.PetNaoCadastradoException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public List<Pet> getPet() {
        return service.listarTodos();
    }

    @GetMapping("/{nome}")
    public Pet getById(@PathVariable String nome) {
        return service.buscarPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetCadastradoException {
       service.cadastrar(pet);
       return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) throws PetNaoCadastradoException {
        service.atualizar(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetCadastradoException{
        service.deletar(nome);
    }

}
