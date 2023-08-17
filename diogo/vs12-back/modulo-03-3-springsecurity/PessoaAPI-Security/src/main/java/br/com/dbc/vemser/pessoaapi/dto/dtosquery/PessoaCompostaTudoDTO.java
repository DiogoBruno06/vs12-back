package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;

import java.time.LocalDate;
import java.util.Set;

public class PessoaCompostaTudoDTO {
    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;

    private Set<EnderecoEntity> enderecos;

    private Set<ContatoEntity> contatos;

    private Set<PetEntity> pets;
}
