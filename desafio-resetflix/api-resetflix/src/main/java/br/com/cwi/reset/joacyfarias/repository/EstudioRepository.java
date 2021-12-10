package br.com.cwi.reset.joacyfarias.repository;

import br.com.cwi.reset.joacyfarias.domain.Estudio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudioRepository extends JpaRepository<Estudio, Integer> {

    Page<Estudio> findAllByNomeContainsIgnoreCase(String nome, Pageable pageable);

}
