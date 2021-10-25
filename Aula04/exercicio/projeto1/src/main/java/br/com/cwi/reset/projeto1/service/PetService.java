package br.com.cwi.reset.projeto1.service;


import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetCadastradoException;
import br.com.cwi.reset.projeto1.exception.PetNaoCadastradoException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PetService {


    @Autowired
    private PetRepository repository;

    public Pet cadastrar(Pet pet) throws PetCadastradoException{
        Pet petCadastrado = repository.findByNome(pet.getNome());

        if (petCadastrado == null){
            throw new PetCadastradoException("Pet com o nome " + pet.getNome() + " Já existe");
        }

        repository.save(pet);
        return pet;
    }

    public List<Pet> listarTodos(){
        return (List<Pet>) repository.findAll();
    }

    public Pet buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public void deletar(String nomePet) throws PetCadastradoException {
        Pet pet = repository.findByNome(nomePet);
        if (pet == null) {
            throw new PetCadastradoException("Pet com o nome " + nomePet + " não existe");
        }
        repository.save(pet);
    }

    public Pet atualizar(Pet pet) throws PetNaoCadastradoException {
        Pet petCadastrado = repository.findByNome(pet.getNome());

        if (pet == null) {
            throw new PetNaoCadastradoException("Pet com o nome " + pet.getNome() + " não existe");
        }
        return repository.save(pet);
    }


}


