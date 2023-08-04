package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idEndereco}")
    public ResponseEntity<Endereco> create(@Valid @PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.create(idEndereco, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@Valid @PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoAlterar = enderecoService.update(idEndereco, enderecoAtualizar);
        return ResponseEntity.ok(enderecoAlterar);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") @Valid Long id) throws Exception {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
