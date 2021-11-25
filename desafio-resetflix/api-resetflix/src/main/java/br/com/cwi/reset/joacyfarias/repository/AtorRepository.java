package br.com.cwi.reset.joacyfarias.repository;


import br.com.cwi.reset.joacyfarias.domain.Ator;
import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

    Page<Ator> findAllByStatusCarreiraAndNomeContainingIgnoreCase(StatusCarreira statusCarreira,
                                                                  String nome,
                                                                  Pageable pageable);

    @Query("select a from Ator a where a.statusCarreira= :statusCarreira")
    Page<Ator> findAllByStatusCarreira(@Param("statusCarreira") StatusCarreira statusCarreira,
                                       Pageable pageable);

}
