package br.com.cwi.api.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class DevolverFilmeResponse {
    private String titulo;
    private Boolean disponivel;
    private String responsavel;
    private LocalDate dataRetirada;
}
