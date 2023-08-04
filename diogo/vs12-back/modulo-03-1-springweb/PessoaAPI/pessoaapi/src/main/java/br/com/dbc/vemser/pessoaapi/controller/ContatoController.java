package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
       this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listById(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listById(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") @Valid Integer idPessoa, @Valid @RequestBody Contato contato) throws Exception {
        return new ResponseEntity<>(contatoService.create(idPessoa,contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                                         @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        Contato contatoAlterado = contatoService.update(id, contatoAtualizar);
        return ResponseEntity.ok(contatoAlterado);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") @Valid Long id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
