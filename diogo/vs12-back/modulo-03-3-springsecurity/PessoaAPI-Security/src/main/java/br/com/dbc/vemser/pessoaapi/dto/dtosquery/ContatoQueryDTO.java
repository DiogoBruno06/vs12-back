package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContatoQueryDTO {
    private String numero;

    public ContatoQueryDTO(String numero) {
        this.numero = numero;
    }
}
