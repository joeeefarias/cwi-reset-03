package br.com.cwi.reset.joacyfarias.repository;

import br.com.cwi.reset.joacyfarias.domain.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {


}
