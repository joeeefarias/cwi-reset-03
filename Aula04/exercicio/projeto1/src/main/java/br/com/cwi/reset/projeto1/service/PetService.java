package br.com.cwi.reset.projeto1.service;


import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetCadastradoException;
import br.com.cwi.reset.projeto1.exception.PetNaoCadastradoException;
import br.com.cwi.reset.projeto1.repository.PetRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetService {


    @Autowired
    private PetRepositoryImpl repository;

    public Pet cadastrar(Pet pet) throws PetCadastradoException{
        Pet petCadastrado = repository.buscarPetPorNome(pet.getNome());

        if (petCadastrado == null){
            throw new PetCadastradoException("Pet com o nome " + pet.getNome() + " Já existe");
        }

        repository.salvarPet(pet);
        return pet;
    }

    public List<Pet> listarTodos() {
        return repository.listarTodos();
    }

    public Pet buscarPorNome(String nome) {
        return repository.buscarPetPorNome(nome);
    }

    public void deletar(String nomePet) throws PetCadastradoException {
        Pet pet = repository.buscarPetPorNome(nomePet);
        if (pet == null) {
            throw new PetCadastradoException("Pet com o nome " + nomePet + " não existe");
        }
        repository.apagarPet(pet);
    }

    public Pet atualizar(Pet pet) throws PetNaoCadastradoException {
        Pet petCadastrado = repository.buscarPetPorNome(pet.getNome());
        if (pet == null) {
            throw new PetNaoCadastradoException("Pet com o nome " + pet.getNome() + " não existe");
        }
        return repository.atualizarPet(pet);
    }


}


