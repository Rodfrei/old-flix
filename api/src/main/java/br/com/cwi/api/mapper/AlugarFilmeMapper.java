package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AlugarFilmeResponse;
import br.com.cwi.api.domain.Filme;

public class AlugarFilmeMapper {

    public static AlugarFilmeResponse toResponse(Filme entity) {
        AlugarFilmeResponse response = new AlugarFilmeResponse();
        response.setTitulo(entity.getTitulo());
        response.setResponsavel(entity.getResponsavel());
        return response;
    }
}
