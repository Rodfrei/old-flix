package br.com.cwi.api.controller;

import br.com.cwi.api.controller.request.AlugarFilmeRequest;
import br.com.cwi.api.controller.request.EditarFilmeRequest;
import br.com.cwi.api.controller.request.IncluirFilmeRequest;
import br.com.cwi.api.controller.response.*;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private ListarFilmeService listarFilmeService;

    @Autowired
    private IncluirFilmeService incluirFilmeService;

    @Autowired
    private AlugarFilmeService alugarFilmeService;

    @Autowired
    private DevolverFilmeService devolverFilmeService;

    @Autowired
    private DetalharFilmeService detalharFilmeService;

    @Autowired
    private RemoverFilmeService removerFilmeService;

    @Autowired
    private EditarFilmeService editarFilmeService;

    @GetMapping
    public List<ListarFilmeResponse> listar(){
        return listarFilmeService.listar();
    }

    @PostMapping
    public IncluirFilmeResponse incluir(@Valid @RequestBody IncluirFilmeRequest request){
        return incluirFilmeService.incluir(request);
    }

    @PutMapping("/{id}/alugar")
    public AlugarFilmeResponse alugar(@PathVariable("id") Long id, @Valid @RequestBody AlugarFilmeRequest request){
        return alugarFilmeService.alugar(id, request);
    }

    @PutMapping("/{id}/devolver")
    public void devolver(@PathVariable("id") Long id){
        devolverFilmeService.devolver(id);
    }

    @GetMapping("/{id}")
    public DetalharFilmeResponse detalhar(@PathVariable("id") Long id) {
        return detalharFilmeService.detalhar(id);
    }

    @DeleteMapping("/{id}")
    public void remover (@PathVariable("id") Long id) {
        removerFilmeService.remover(id);
    }

    @PutMapping("{id}")
    public EditarFilmeResponse editar(@PathVariable("id") Long id, @Valid @RequestBody EditarFilmeRequest request){
        return editarFilmeService.editar(id, request);
    }
}


