package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.LoginCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AuthControllerDoc {

    @Operation(summary = "Faz login no sistema", description = "Faz login no sistema")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o token de acesso"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException;

    @Operation(summary = "Cria um login no sistema", description = "Cria login no sistema, é necessário estar logado como ADMIN")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna que o login foi criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/cadastro")
    ResponseEntity<LoginCreateDTO> loginCreate(@RequestBody @Valid LoginCreateDTO loginCreateDTO) throws RegraDeNegocioException;


}
