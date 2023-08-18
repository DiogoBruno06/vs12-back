package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        enderecoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                             @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.create(idPessoa,endereco), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("id") Integer id,
                                 @RequestBody EnderecoCreateDTO enderecoEntity) throws Exception {
        return new ResponseEntity<>(enderecoService.update(id,enderecoEntity), HttpStatus.OK);
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO findById(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.getById(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoEntity> findByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.getByIdPessoa(idPessoa);
    }



    @GetMapping("/query-endereco")
    public List<EnderecoQueryDTO> getDados() {
        return enderecoService.findAllByCep();
    }
}
