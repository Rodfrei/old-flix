package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.EditarFilmeRequest;
import br.com.cwi.api.controller.response.EditarFilmeResponse;
import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.cwi.api.mapper.EditarFilmeMapper.toResponse;

@Service
public class EditarFilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ValidaFilmeDisponivelService validaFilmeDisponivelService;

    @Autowired
    ValidaFilmeEncontradoService validaFilmeEncontradoService;

    public EditarFilmeResponse editar(Long id, EditarFilmeRequest request) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);
        Filme filme = validaFilmeEncontradoService.validar(filmeProcurado);

        validaFilmeDisponivelService.validar(filme, "Não esta disponivel para ser editado.");

        filme.setTitulo(request.getTitulo());
        filme.setDescricao(request.getDescricao());
        filme.setCategoria(request.getCategoria());
        filme.setUrl(request.getUrl());
        filme.setAno(request.getAno());
        filme.setDuracao(request.getDuracao());

        filmeRepository.save(filme);

        return toResponse(filme);
    }
}
