package br.com.cwi.api.service;

import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidaFilmeIndisponivelService {
    @Autowired
    private FilmeRepository filmeRepository;

    public void validar(Filme filme, String s) {
        if(filme.isDisponivel()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Este filme ja esta disponível!");
        }
    }
}
