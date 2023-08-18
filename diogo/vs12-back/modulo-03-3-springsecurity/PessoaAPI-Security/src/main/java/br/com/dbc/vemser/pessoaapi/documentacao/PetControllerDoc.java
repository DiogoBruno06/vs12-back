package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PetControllerDoc {

    @Operation(summary = "Lista todos os pets", description = "Lista todos os pets cadastrados no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Mostra todos os pets"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    List<PetDTO> list();

    @Operation(summary = "Cria um cadastro de pet", description = "Cria um cadastro de pet com um idPessoa passado como parametro")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria um pet"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    ResponseEntity<PetDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                         @RequestBody PetCreateDTO petCreateDTO) throws Exception;

    @Operation(summary = "Edita um pet", description = "Edita um pet com o id passado na requisição")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edita um pet"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{id}")
    PetDTO update(@PathVariable("id") Integer id,
                         @RequestBody PetCreateDTO petCreateDTO) throws Exception;

    @Operation(summary = "Deleta um pet", description = "Deleta com o id passado na requisição")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta um pet"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id) throws Exception;

    @Operation(summary = "Query personalizada para mostrar nomes de pet", description = "Faz uma query personalizada para mostrar apenas os nomes de pets")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Query para pets com seus devidos nomes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/nome-pet")
    List<PetQueryDTO> petQuery();
}
