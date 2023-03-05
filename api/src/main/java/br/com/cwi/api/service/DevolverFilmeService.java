package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevolverFilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private ValidaFilmeIndisponivelService validaFilmeIndisponivelService;

    @Autowired
    private ValidaFilmeEncontradoService validaFilmeEncontradoService;

    public void devolver(Long id) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);

        Filme filme = validaFilmeEncontradoService.validar(filmeProcurado);

        validaFilmeIndisponivelService.validar(filme, "Filme já esta disponivel.");
        filme.setDisponivel(true);
        filme.setResponsavel(null);
        filme.setDataRetirada(null);

        filmeRepository.save(filme);
    }
}
