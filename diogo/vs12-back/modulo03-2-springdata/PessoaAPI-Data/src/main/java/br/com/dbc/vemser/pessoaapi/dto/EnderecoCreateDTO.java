package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {

    @NotNull(message = "idPessoa não pode ser nulo")
    private Integer idPessoa;

    @NotNull(message = "Tipo não pode ser nulo")
    private TipoEndereco tipo;

    @NotNull(message = "Logradouro não pode ser nulo")
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
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

    @Override
    public String toString() {
        return "Endereco"+
                ", Tipo: \n" + tipo +
                ", Logradouro:" + logradouro + "\n" +
                ", Número:" + numero +
                ", Complemento: " + complemento + "\n" +
                ", \n CEP: " + cep + "\n" +
                ", Cidade: " + cidade + "\n" +
                ", Estado: " + estado + "\n" +
                ", País: " + pais + "\n";
    }
}
