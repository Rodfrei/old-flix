package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AlugarFilmeRequest;
import br.com.cwi.api.controller.response.AlugarFilmeResponse;
import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static br.com.cwi.api.mapper.AlugarFilmeMapper.toResponse;

@Service
public class AlugarFilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ValidaFilmeDisponivelService validaFilmeDisponivelService;

    @Autowired
    private ValidaFilmeEncontradoService validaFilmeEncontradoService;

    public AlugarFilmeResponse alugar(Long id, AlugarFilmeRequest request) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);

        Filme filme = validaFilmeEncontradoService.validar(filmeProcurado);

        validaFilmeDisponivelService.validar(filme, "Filme já foi alugado.");

        filme.setResponsavel(request.getResponsavel());
        filme.setDisponivel(false);
        filme.setDataRetirada(LocalDate.now());
        filmeRepository.save(filme);
        return toResponse(filme);
    }
}
