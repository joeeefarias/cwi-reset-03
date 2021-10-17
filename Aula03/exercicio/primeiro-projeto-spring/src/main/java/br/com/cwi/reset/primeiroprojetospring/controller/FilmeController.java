package br.com.cwi.reset.primeiroprojetospring.controller;


import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/filme")
public class FilmeController {


    private static List<Filme> filmes = new ArrayList<>();


    @GetMapping
    public List<Filme> consultaTodos() {
        return filmes;
    }

    private Filme buscaPeloNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }

    @GetMapping("{/nome}")
    public Filme buscaFilmePeloNome(@PathVariable String nome) {
        return buscaPeloNome(nome);

    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme){
        Filme filmecadastrado = buscaPeloNome(filme.getNome());
        if (filmecadastrado != null){
            return ResponseEntity.badRequest().build();
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme){
        Filme filmeCadastrado = buscaPeloNome(filme.getNome());

        if (filmeCadastrado != null) {
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
        }

        return null;
    }

    @DeleteMapping("/{nome}")
    public  void deletarFilme(@PathVariable String nome){
        Filme filme = buscaPeloNome(nome);
        if (filme != null){
            filmes.remove(filme);
        }
    }


}



