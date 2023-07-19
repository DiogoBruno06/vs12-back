package entities;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public void imprimirEndereco(){
        for (Endereco endereco : enderecos){
            if (endereco != null){
                System.out.println("Pais: "+endereco.getPais());
                System.out.println("Estado: "+endereco.getEstado());
                System.out.println("Cidade: "+endereco.getCidade());
                System.out.println("CEP: "+endereco.getCep());
                System.out.println("Logradouro: "+endereco.getLogradouro());
                System.out.println("Complemento: "+endereco.getComplemento());
                System.out.println("Numero: "+endereco.getNumero());
                System.out.println("Tipo: "+endereco.getTipo());
            }
        }
    }

    public void imprimirContato(){
        for (Contato contato : contatos){
            if (contato != null){
                System.out.println("Tipo: "+ contato.getTipo());
                System.out.println("Telefone: "+contato.getTelefone());
                System.out.println("Descrição: "+contato.getDescricao());
            }
        }
    }

    public void imprimirCliente(){
        System.out.printf("O nome do cliente é: %s, o CPF é: %s",this.nome, this.cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
}
