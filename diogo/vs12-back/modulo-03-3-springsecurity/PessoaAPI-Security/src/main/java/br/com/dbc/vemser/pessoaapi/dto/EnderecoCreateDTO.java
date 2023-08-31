package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {

    @NotNull(message = "Tipo não pode ser nulo")
    private TipoEndereco tipo;

    @NotNull(message = "Logradouro não pode ser nulo")
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    @Size(min = 1, max = 3)
    private Integer numero;

    private String complemento;

    @NotNull(message = "CEP não pode ser nulo")
    @NotEmpty
    @Size(min = 1, max = 8)
    private String cep;

    @NotNull(message = "Cidade não pode ser nulo")
    @NotEmpty
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    private String estado;

    @NotNull(message = "Pais não pode ser nulo")
    private String pais;
}
