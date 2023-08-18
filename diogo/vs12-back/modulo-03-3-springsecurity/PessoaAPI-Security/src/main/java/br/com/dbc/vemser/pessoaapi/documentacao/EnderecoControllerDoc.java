package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EnderecoControllerDoc {
    @Operation(summary = "Listar todos os endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    List<EnderecoDTO> list();

    @Operation(summary = "Listar todos os endereços por id", description = "Lista todos os endereços por id no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços por id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    EnderecoEntity findById(@PathVariable("idEndereco") Integer id) throws Exception;

    @Operation(summary = "Cria um endereco pelo idPessoa", description = "Cria um endereço com o id passado na requisição")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um endereço pelo id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                              @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Edita um endereco pelo id", description = "Altera dados de um endereço onde o id foi passado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita um endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{id}")
    ResponseEntity<EnderecoDTO> update(@PathVariable("id") Integer id,
                                              @RequestBody EnderecoCreateDTO enderecoEntity) throws Exception;

    @Operation(summary = "Remove um endereço", description = "Remove um endereço pelo id passado na requisição")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Remove um endereço pelo id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) throws Exception;

    @Operation(summary = "Faz uma query personalizada para endereco", description = "Faz uma query personalizada para endereco mostrando CEP,cidade,estado e pais")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Query feita com sucesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/query-endereco")
    List<EnderecoQueryDTO> getDados();
}
