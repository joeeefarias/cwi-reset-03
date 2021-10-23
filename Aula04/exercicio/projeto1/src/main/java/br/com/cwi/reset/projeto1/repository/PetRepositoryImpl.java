package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PetRepositoryImpl implements PetRepository{

    private List<Pet> pets = new ArrayList<>();

    public Pet buscarPetPorNome(String nome){
        for ( Pet pet : pets){
            if (pet.getNome().equals(nome)){
                return pet;
            }
        }
        return null;
    }

    public Pet salvarPet(Pet pet){
        pets.add(pet);
        return pet;
    }

    public void apagarPet(Pet pet){
        pets.remove(pet);
    }

    public Pet atualizarPet(Pet pet){
        Pet petCadastrado = buscarPetPorNome(pet.getNome());

        if (petCadastrado != null){
            pets.remove(petCadastrado);
            pets.add(pet);
            return pet;

        }
        return null;
    }

    public List<Pet> listarTodos() {
        return pets;
    }

}
