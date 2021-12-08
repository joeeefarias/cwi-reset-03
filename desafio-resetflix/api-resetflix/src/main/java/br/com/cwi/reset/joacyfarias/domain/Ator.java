package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.StatusCarreira;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private StatusCarreira statusCarreira;

    private LocalDate anoInicioAtividade;

    private String avatarUrl;


}


