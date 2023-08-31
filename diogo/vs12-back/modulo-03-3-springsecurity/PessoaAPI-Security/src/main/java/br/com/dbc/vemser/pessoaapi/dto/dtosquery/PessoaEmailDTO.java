package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaEmailDTO {
    private Integer IdPessoa;
    private String Nome;
    private String Email;

    public PessoaEmailDTO(Integer idPessoa, String nome, String email) {
        IdPessoa = idPessoa;
        Nome = nome;
        Email = email;
    }
}
