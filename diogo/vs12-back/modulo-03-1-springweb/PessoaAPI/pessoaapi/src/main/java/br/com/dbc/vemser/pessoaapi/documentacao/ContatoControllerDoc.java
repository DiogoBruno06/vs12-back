package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

public interface ContatoControllerDoc {
    @Operation(summary = "Listar contato pelo idPessoa", description = "Lista todos os contatos cadastrados com o idPessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar a lista de contatos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping
    public List<Contato> listById(@PathVariable("idPessoa") Integer idPessoa);

    @Operation(summary = "Listar todos os contatos", description = "Lista todos os contatos cadastrados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<Contato> list();

    @Operation(summary = "Criar contato", description = "Criando cadastro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Criar cadastro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<ContatoCreateDTO> create(@Valid @RequestBody ContatoDTO contato) throws RegraDeNegocioException, MessagingException;

    @Operation(summary = "Edita contato", description = "Editando cadastro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editar cadastro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PutMapping
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                                          @Valid @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException;

    @Operation(summary = "Remove contato", description = "Removendo cadastro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Remover cadastro"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable("idContato") @Valid Integer id) throws RegraDeNegocioException;

}
