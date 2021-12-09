package br.com.cwi.reset.joacyfarias.domain;

import br.com.cwi.reset.joacyfarias.enumeration.StatusAtividade;
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
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusAtividade statusAtividade;

}
