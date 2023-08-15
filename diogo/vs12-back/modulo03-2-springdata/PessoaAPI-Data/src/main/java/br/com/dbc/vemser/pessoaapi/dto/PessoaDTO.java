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
    @ManyToMany
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private Set<EnderecoDTO> enderecos;

    private Set<PetCreateDTO> pets;
}
