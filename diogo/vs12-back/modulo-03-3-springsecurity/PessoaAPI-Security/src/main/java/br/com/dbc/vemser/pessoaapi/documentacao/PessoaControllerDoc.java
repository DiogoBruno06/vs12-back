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

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    ResponseEntity<List<PessoaDTO>> list();
    ;


    @Operation(summary = "Atualiza os dados da pessoa", description = "Atualiza o pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}")
    ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws Exception;

    @Operation(summary = "Cria uma pessoa no sistema", description = "Cria uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Criar uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa);


    @Operation(summary = "Deleta uma pessoa no sistema", description = "Deleta uma pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}")
    ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception;


    @Operation(summary = "Lista todas pessoa no sistema por ID", description = "Lista todas as pessoas, caso não tenha id ele lista todas as pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista todas as pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/pessoa-completo")
    List<PessoaEntity> getAllPessoas(@RequestParam(name = "idPessoa", required = false) Integer idPessoa);


    @Operation(summary = "Busca todos os dados da pessoa ", description = "Lista todas as pessoas, caso não tenha id ele lista todas as pessoas")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista todas as pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/query-pessoa")
    public List<PessoaEmailDTO> getDados();
}
