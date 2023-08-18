package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.ContatoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContatoControllerDoc {

    @Operation(summary = "Listar todos os contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    List<ContatoDTO> list();

    @Operation(summary = "Busca Contatos pelo idContato", description = "Busca contato por id")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato que foi passado o id"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idContato}")
    ContatoEntity findById(@PathVariable("idContato") Integer id) throws Exception;


    @Operation(summary = "Cria um contato", description = "Cria um contato com o idPessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato com todas as informações cadastradas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                      @RequestBody ContatoCreateDTO contato) throws Exception;

    @Operation(summary = "Busca o contato pelo id", description = "Busca contato por id e atualiza ele com os dados passados na requisição")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato que foi passado o id, mostrando os novos dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{id}")
    ContatoDTO update(@PathVariable("id") Integer id,
                             @RequestBody ContatoCreateDTO contato) throws Exception;

    @Operation(summary = "Deleta contato pelo id", description = "Busca contato por id e deleta ele do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contato excluído"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) throws Exception;

    @Operation(summary = "Query por número", description = "Busca todos os números cadastrados em contatos")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todos os números cadastrados no sistema"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/numeroContato")
    List<ContatoQueryDTO> mostraNumero();
}
