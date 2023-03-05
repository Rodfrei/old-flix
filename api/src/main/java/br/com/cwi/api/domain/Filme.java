package br.com.cwi.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.EnumType.*;

@Getter @Setter
@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private boolean disponivel;

    @Enumerated(STRING)
    private Categoria categoria;

    private String responsavel;
    private LocalDate dataRetirada;
    private String url;
    private int ano;
    private int duracao;
}
