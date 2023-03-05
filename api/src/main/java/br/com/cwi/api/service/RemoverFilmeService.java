package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoverFilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ValidaFilmeDisponivelService validaFilmeDisponivelService;

    @Autowired
    ValidaFilmeEncontradoService validaFilmeEncontradoService;

    public void remover(Long id) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);
        Filme filme = validaFilmeEncontradoService.validar(filmeProcurado);

        validaFilmeDisponivelService.validar(filme, "Filme não esta disponivel para ser deletado.");

        filmeRepository.deleteById(id);
    }
}
