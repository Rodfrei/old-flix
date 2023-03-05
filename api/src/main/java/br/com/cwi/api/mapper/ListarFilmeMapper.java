package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarFilmeResponse;
import br.com.cwi.api.domain.Filme;

public class ListarFilmeMapper {

    public static ListarFilmeResponse toResponse(Filme entity) {
        ListarFilmeResponse response = new ListarFilmeResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getTitulo());
        response.setDescricao(entity.getDescricao());
        response.setDisponivel(entity.isDisponivel());
        response.setCategoria(entity.getCategoria());
        response.setUrl(entity.getUrl());
        response.setAno(entity.getAno());
        response.setDuracao(entity.getDuracao());

        return response;

    }
}
