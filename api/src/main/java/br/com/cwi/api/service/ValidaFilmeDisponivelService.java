package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidaFilmeDisponivelService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void validar(Filme filme, String menssagem) {
        if(!filme.isDisponivel()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, menssagem);
        }
    }
}
