package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {
    private final PessoaService pessoaService;

    @GetMapping
    public Page<PessoaEntity> getPessoas(Integer pagina, Integer quantidadeRegistros) {
        return pessoaService.listPaginado(pagina, quantidadeRegistros);
    }


}