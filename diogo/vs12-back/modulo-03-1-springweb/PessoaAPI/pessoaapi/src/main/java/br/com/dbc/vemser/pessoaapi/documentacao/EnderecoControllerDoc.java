package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

public interface EnderecoControllerDoc {
    @Operation(summary = "Listar endereco pelo idPessoa", description = "Lista todos os enderecos cadastrados com o idPessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar a lista de enderecos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException;

    @Operation(summary = "Listar endereco pelo idEndereco", description = "Lista todos os enderecos cadastrados com o idEndereco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar a lista de enderecos pelo id passado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException;

    @Operation(summary = "Listar endereco", description = "Lista todos os enderecos cadastrados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retornar a lista de enderecos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<Endereco> list() throws RegraDeNegocioException;

    @Operation(summary = "Cria endereco", description = "criar endereco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Criar endereco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException, MessagingException;

    @Operation(summary = "Edita endereco", description = "editar endereco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editar endereco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping
    public ResponseEntity<Endereco> update(@Valid @PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;


    @Operation(summary = "Remove endereco", description = "deleta endereco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Remover endereco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") @Valid Integer id, EnderecoCreateDTO idEndereco) throws RegraDeNegocioException, TemplateException, MessagingException, IOException;
}
