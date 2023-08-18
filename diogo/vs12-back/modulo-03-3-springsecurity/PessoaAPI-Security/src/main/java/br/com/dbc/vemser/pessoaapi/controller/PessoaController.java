package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pessoa")
public class PessoaController{


    private final PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    @GetMapping("/byname")
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    // Atualizar pessoa
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws Exception {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/pessoa-completo")
    public List<PessoaEntity> getAllPessoas(@RequestParam(name = "idPessoa", required = false) Integer idPessoa) {
        return pessoaService.getAllPessoas(idPessoa);
    }

    @GetMapping("/query-pessoa")
    public List<PessoaEmailDTO> getDados() {
        return pessoaService.findAllPessoaEmailDTO();
    }
}
