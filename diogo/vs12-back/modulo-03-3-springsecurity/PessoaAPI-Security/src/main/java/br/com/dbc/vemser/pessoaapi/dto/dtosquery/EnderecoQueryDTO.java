package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoQueryDTO {
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public EnderecoQueryDTO(String cep, String cidade, String estado, String pais) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
