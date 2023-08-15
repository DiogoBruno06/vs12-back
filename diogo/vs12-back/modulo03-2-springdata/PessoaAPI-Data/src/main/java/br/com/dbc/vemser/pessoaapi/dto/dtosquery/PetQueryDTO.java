package br.com.dbc.vemser.pessoaapi.dto.dtosquery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetQueryDTO {
    private String nome;

    public PetQueryDTO(String nome) {
        this.nome = nome;
    }
}
