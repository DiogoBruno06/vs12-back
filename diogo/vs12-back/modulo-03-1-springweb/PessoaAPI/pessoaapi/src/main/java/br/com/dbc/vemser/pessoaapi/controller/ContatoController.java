package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
       this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byid")
    public List<Contato> listById(@RequestParam("idPessoa") Integer idPessoa) {
        return contatoService.listById(idPessoa);
    }

    @PostMapping
    public Contato create(@PathVariable("idPessoa") Integer idPessoa,@RequestBody Contato contato) throws Exception {
        return contatoService.create(idPessoa,contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Long id) throws Exception {
        contatoService.delete(id);
    }


}
