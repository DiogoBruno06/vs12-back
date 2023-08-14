package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "Identificador único da pessoa")
    private Integer idPessoa;

    private Set<ContatoCreateDTO> contatos;
    private Set<EnderecoCreateDTO> enderecos;
    private Set<PetCreateDTO> pets;
}
