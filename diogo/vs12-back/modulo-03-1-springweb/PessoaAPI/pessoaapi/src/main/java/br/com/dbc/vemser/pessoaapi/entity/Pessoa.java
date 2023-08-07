package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @NotNull
    private Integer idPessoa;

    @NotNull
    @Size(max=30)
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    private String cpf;

}