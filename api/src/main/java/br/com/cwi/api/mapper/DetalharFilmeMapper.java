package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.DetalharFilmeResponse;
import br.com.cwi.api.domain.Filme;

public class DetalharFilmeMapper {
    public static DetalharFilmeResponse toResponse(Filme entity) {
        DetalharFilmeResponse response = new DetalharFilmeResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getTitulo());
        response.setDescricao(entity.getDescricao());
        response.setDisponivel(entity.isDisponivel());
        response.setCategoria(entity.getCategoria());
        response.setUrl(entity.getUrl());
        response.setResponsavel(entity.getResponsavel());
        response.setDataRetirada(entity.getDataRetirada());
        response.setAno(entity.getAno());
        response.setDuracao(entity.getDuracao());

        return response;
    }
}
