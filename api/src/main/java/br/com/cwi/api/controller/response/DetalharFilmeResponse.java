package br.com.cwi.api.controller.response;

import br.com.cwi.api.domain.Categoria;
import br.com.cwi.api.domain.Situacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Enumerated;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.*;
import static javax.persistence.EnumType.*;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class DetalharFilmeResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean disponivel;
    private Categoria categoria;
    private String responsavel;
    private LocalDate dataRetirada;
    private String url;
    private Integer ano;
    private Integer duracao;
    private LocalDate dataEntrega;

    @Enumerated(STRING)
    private Situacao situacao;

}
