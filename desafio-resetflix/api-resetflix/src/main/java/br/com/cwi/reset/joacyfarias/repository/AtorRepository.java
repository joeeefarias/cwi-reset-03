package br.com.cwi.reset.joacyfarias.repository;


import br.com.cwi.reset.joacyfarias.domain.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator finBynome(String nome);
    List<Ator> findAll();
    List<Ator> findByStatusCarreira(String statusCarreira);

}
