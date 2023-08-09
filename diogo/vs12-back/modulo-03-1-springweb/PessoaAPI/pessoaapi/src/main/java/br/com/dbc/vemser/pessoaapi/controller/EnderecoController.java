package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
@Log4j2
public class EnderecoController implements EnderecoControllerDoc {
    private final EnderecoService enderecoService;

    @Autowired
    private EmailService emailService;

    private final PessoaService pessoaService;

    public EnderecoController(EnderecoService enderecoService, PessoaService pessoaService) {
        this.enderecoService = enderecoService;
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Endereco> list() throws RegraDeNegocioException{
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException{
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException{
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException, MessagingException {
        log.info("Criando");
        return new ResponseEntity<>(enderecoService.create(endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@Valid @PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        log.info("Editando");
        Endereco enderecoAlterar = enderecoService.update(idEndereco, enderecoAtualizar);
        return ResponseEntity.ok(enderecoAlterar);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") @Valid Integer id, EnderecoCreateDTO idEndereco) throws RegraDeNegocioException, TemplateException, MessagingException, IOException {
        log.info("Deletando");
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
