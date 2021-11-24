package br.com.cwi.reset.joacyfarias.repository;


import br.com.cwi.reset.joacyfarias.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

//    List<Ator> findByNomeLikeAndStatusCarreiraIs(String nome, String statusCarreira);
    Ator findByIdEquals(Integer id);
}
