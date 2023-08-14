package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO extends PetCreateDTO{

    private Integer idPet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoaPet;
}
