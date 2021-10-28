package br.com.cwi.reset.joacyfarias.repository;


import br.com.cwi.reset.joacyfarias.domain.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    List<Ator> findAll();
    List<Ator> findByStatusCarreira(String statusCarreira);
    Ator findByIdEquals(Integer id);
}
