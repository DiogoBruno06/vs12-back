package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoaContato;
}
