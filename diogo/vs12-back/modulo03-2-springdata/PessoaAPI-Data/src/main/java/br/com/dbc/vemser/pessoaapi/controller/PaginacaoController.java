package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaCompostaTudoDTO;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/paginacao")
//public class PaginacaoController {
//
//    private PessoaRepository pessoaRepository;
//
//    //@GetMapping("/relatorio-paginado")
//   // public Page<PessoaCompostaTudoDTO> getRelatorioPaginado(Integer pagina, Integer quantidadeRegistros){
//    //    Sort ordenacao = Sort.by("nome").descending()
//    //            .and(Sort.by("cpf"));
//     //   Pageable pageable = PageRequest.of(pagina, quantidadeRegistros, ordenacao);
//     //   return pessoaRepository.findPessoaCompostaTudoPaginado(pageable);
//   // }
////}
