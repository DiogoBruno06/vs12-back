package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaCreateDTO {

    @Schema(description = "Nome da pessoa")
    @NotBlank
    private String nome;

    @Schema(description = "AAAA-MM-DD")
    @Past
    @NotNull
    private LocalDate dataNascimento;

    @Schema(description = "CPF válido")
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @Schema(description = "seuEmail@dominio")
    @Email
    private String email;
}
