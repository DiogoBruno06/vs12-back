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

    @NotNull
    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipo;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
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
