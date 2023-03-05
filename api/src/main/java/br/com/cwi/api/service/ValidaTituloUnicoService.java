package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaTituloUnicoService {

    @Autowired
    FilmeRepository filmeRepository;

    public void validar(String titulo) {
        Filme filme = filmeRepository.findByTitulo(titulo);

        if(Objects.nonNull(filme)){
            throw new ResponseStatusException(BAD_REQUEST, "Ja existe um filme com este titulo!!.");
        }
    }
}
