package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {
    @NotEmpty
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotEmpty
    @NotNull(message = "CPF não pode ser nulo")
    private String cpf;
}
