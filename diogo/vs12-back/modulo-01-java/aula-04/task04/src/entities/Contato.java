package entities;

public class Contato {
    private String descricao;
    private String telefone;
    private Integer tipo;

    public void imprimirContato(){
        System.out.printf("A descrição do contato é: %s, o telefone para contato é: %s, e o tipo é: %d%n",this.descricao,this.telefone,this.tipo);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
