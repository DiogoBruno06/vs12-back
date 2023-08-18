package br.com.dbc.vemser.pessoaapi.documentacao;


import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


public interface PessoaControllerDoc {
    
    @Operation(summary = "Busca pessoas pelo nome", description = "Busca pessoas pelo nome cadastrado no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas com um certo nome"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/byname")
    ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome);

    @Operation(summary = "Cria uma pessoa no sistema", description = "Cadastra uma pessoa no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todos os dados cadastrados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa);

    @Operation(summary = "Edita uma pessoa", description = "Edita uma pessoa cadastrada no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todos os dados atualizados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws Exception;

    @Operation(summary = "Deleta uma pessoa", description = "Remove uma pessoa do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Pessoa removida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception;

    @Operation(summary = "Retorna todos os dados da pessoa", description = "Retorna todos os dados vinculudos a uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna todos os dados vinculudos a uma pessoa e seus relacionamentos com outras entidades"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/pessoa-completo")
    List<PessoaEntity> getAllPessoas(@RequestParam(name = "idPessoa", required = false) Integer idPessoa);

    @Operation(summary = "Retorna email e nome da pessoa", description = "Retorna email e nome da pessoa onde o id foi passado")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna email e nome da pessoa onde o id foi passado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/query-pessoa")
    List<PessoaEmailDTO> getDados();
}
