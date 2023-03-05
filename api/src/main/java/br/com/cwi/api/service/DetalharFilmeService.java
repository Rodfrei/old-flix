package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.DetalharFilmeResponse;
import br.com.cwi.api.domain.Filme;
import br.com.cwi.api.mapper.DetalharFilmeMapper;
import br.com.cwi.api.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static br.com.cwi.api.domain.Situacao.*;

@Service
public class DetalharFilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ValidaFilmeEncontradoService validaFilmeEncontradoService;


    public DetalharFilmeResponse detalhar(Long id) {
        Optional<Filme> filmeProcurado = filmeRepository.findById(id);
        Filme filme = validaFilmeEncontradoService.validar(filmeProcurado);

        DetalharFilmeResponse response = DetalharFilmeMapper.toResponse(filme);
        if(!response.getDisponivel()){
            response.setDataEntrega(
                    response.getDataRetirada().plusDays(
                            response.getCategoria().getPrazoParaDevolucao()
                    )
            );
            if(response.getDataEntrega().isBefore(LocalDate.now())){
                response.setSituacao(EM_ATRASO);
            } else {
                response.setSituacao(EM_DIA);
            }
        }
        return response;
    }
}
