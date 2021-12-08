package br.com.cwi.reset.joacyfarias.repository;

import br.com.cwi.reset.joacyfarias.domain.Diretor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Integer> {

    Page<Diretor> findAllByNomeEqualsIgnoreCase(String nome, Pageable pageable);


}
