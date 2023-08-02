package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
       contatoService = new ContatoService();
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byid") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Contato> listByName(@RequestParam("id") Integer id) {
        return contatoService.listById(id);
    }

    @PostMapping // POST localhost:8080/pessoa
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}") // PUT localhost:8080/pessoa/1000
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }


}
