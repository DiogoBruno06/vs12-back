public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirEndereco(){
        for (Endereco endereco : enderecos){
            if (endereco != null){
                System.out.println("Pais: "+endereco.pais);
                System.out.println("Estado: "+endereco.estado);
                System.out.println("Cidade: "+endereco.cidade);
                System.out.println("CEP: "+endereco.cep);
                System.out.println("Logradouro: "+endereco.logradouro);
                System.out.println("Complemento: "+endereco.complemento);
                System.out.println("Numero: "+endereco.numero);
                System.out.println("Tipo: "+endereco.tipo);
            }
        }
    }

    public void imprimirContato(){
        for (Contato contato : contatos){
            if (contato != null){
                System.out.println("Tipo: "+contato.tipo);
                System.out.println("Telefone: "+contato.telefone);
                System.out.println("Descrição: "+contato.descricao);
            }
        }
    }

    public void imprimirCliente(){
        System.out.printf("O nome do cliente é: %s, o CPF é: %s",this.nome, this.cpf);
    }
}
