package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.EditarFilmeResponse;
import br.com.cwi.api.domain.Filme;

public class EditarFilmeMapper {
    public static EditarFilmeResponse toResponse(Filme entity) {
        EditarFilmeResponse response = new EditarFilmeResponse();
        response.setId(entity.getId());
        response.setTitulo(entity.getTitulo());
        return response;
    }
}
