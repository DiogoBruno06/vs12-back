package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
@Log4j2
public class ContatoController implements ContatoControllerDoc {
    private final ContatoService contatoService;

    @Autowired
    private EmailService emailService;

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

    @PostMapping
    public ResponseEntity<ContatoCreateDTO> create(@Valid @RequestBody ContatoDTO contato) throws RegraDeNegocioException, MessagingException {
        log.info("Criando");
        return new ResponseEntity<>(contatoService.create(contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                                         @Valid @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException {
        log.info("Editando");

        Contato contatoAlterado = contatoService.update(id, contatoAtualizar);
        return ResponseEntity.ok(contatoAlterado);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") @Valid Integer id) throws RegraDeNegocioException {
        log.info("Deletando");
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }


}
