package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LoginCreateDTO {
    @NotNull
    private String login;
    @NotNull
    private String senha;
    @NotNull
    private List<Integer> cargos;
}