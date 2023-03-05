package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.IncluirFilmeRequest;
import br.com.cwi.api.controller.response.IncluirFilmeResponse;
import br.com.cwi.api.domain.Filme;

public class IncluirFilmeMapper {
    public static Filme toEntity(IncluirFilmeRequest request) {
        Filme entity = new Filme();
        entity.setTitulo(request.getTitulo());
        entity.setDescricao(request.getDescricao());
        entity.setCategoria(request.getCategoria());
        entity.setUrl(request.getUrl());
        entity.setAno(request.getAno());
        entity.setDuracao(request.getDuracao());
        return entity;
    }

    public static IncluirFilmeResponse toResponse(Filme entity) {
        IncluirFilmeResponse response = new IncluirFilmeResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getTitulo());
        return response;
    }
}
