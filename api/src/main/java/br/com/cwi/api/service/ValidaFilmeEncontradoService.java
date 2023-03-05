package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class ValidaFilmeEncontradoService {
    public Filme validar(Optional<Filme> filmeProcurado) throws ResponseStatusException {
        if(filmeProcurado.isEmpty()){
            throw new ResponseStatusException(BAD_REQUEST, "Filme não encontrado!!.");
        }
        return filmeProcurado.get();
    }
}
