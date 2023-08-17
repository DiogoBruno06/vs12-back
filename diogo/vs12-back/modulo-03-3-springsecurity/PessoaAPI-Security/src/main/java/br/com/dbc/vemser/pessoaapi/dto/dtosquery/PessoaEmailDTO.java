package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaEmailDTO {
    private Integer getIdPessoa;
    private String getNome;
    private String getEmail;

    public PessoaEmailDTO(Integer getIdPessoa, String getNome, String getEmail) {
        this.getIdPessoa = getIdPessoa;
        this.getNome = getNome;
        this.getEmail = getEmail;
    }
}
