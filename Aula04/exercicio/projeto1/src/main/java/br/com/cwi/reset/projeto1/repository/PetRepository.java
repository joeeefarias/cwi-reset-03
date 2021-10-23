package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    Pet buscarPetPorNome(String nome);

    Pet salvarPet(Pet pet);

    void apagarPet(Pet pet);

    Pet atualizarPet(Pet pet);

    public List<Pet> listarTodos();
}
