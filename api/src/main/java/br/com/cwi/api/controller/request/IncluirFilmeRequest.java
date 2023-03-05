package br.com.cwi.api.controller.request;

import br.com.cwi.api.domain.Categoria;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class IncluirFilmeRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private Categoria categoria;
    @NotBlank
    private String url;
    @NotNull
    private Integer ano;
    @NotNull
    private Integer duracao;
}
