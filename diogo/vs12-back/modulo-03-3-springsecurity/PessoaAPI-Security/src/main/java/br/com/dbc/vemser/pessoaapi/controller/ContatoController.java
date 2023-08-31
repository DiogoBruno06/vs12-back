package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.documentacao.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.ContatoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController implements ContatoControllerDoc {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("/{idContato}")
    public ContatoEntity findById(@PathVariable("idContato") Integer id) throws Exception {
        return contatoService.findById(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                 @RequestBody ContatoCreateDTO contato) throws Exception {
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                                @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/query-contato")
    public List<ContatoQueryDTO> numeroContato() {
        return contatoService.getAllByNumero();
    }
}