package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.IncluirFilmeRequest;
import br.com.cwi.api.controller.response.IncluirFilmeResponse;
import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.api.mapper.IncluirFilmeMapper.*;

@Service
public class IncluirFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ValidaTituloUnicoService validaTituloUnicoService;

    public IncluirFilmeResponse incluir(IncluirFilmeRequest request) {

        validaTituloUnicoService.validar(request.getTitulo());

        Filme filme = toEntity(request);
        filme.setDisponivel(true);
        filmeRepository.save(filme);

        return toResponse(filme);
    }
}
