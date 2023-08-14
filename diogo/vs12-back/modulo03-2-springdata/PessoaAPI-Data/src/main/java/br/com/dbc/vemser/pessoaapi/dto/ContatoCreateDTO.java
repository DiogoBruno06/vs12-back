package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoCreateDTO{

    @NotNull(message = "Tipo não pode ser nulo")
    private TipoContato tipoContato;

    @NotNull(message = "Número não pode ser nulo")
    @Size(max = 13)
    private String numero;

    @NotNull(message = "Descrição não pode ser nulo")
    @NotEmpty
    private String descricao;
}
