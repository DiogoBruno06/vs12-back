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

    public PessoaEmailDTO(Integer IdPessoa, String Nome, String Email) {
        this.IdPessoa = IdPessoa;
        this.Nome = Nome;
        this.Email = Email;
    }
}
