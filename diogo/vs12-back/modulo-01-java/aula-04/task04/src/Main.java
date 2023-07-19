import entities.*;

public class Main {
    public static void main(String[] args) {
        Contato contato1 = new Contato();
        contato1.setDescricao( "Contato para Diogo Bruno"); 
        contato1.setTelefone("986060610");
        contato1.setTipo(1);


        Contato contato2 = new Contato();
        contato2.setDescricao("Bruno Diogo");
        contato2.setTelefone("912334456");
        contato2.setTipo(2);


        Endereco endereco1 = new Endereco();
        endereco1.setCep("58038270");
        endereco1.setTipo(1);
        endereco1.setCidade("João Pessoa");
        endereco1.setEstado("Paraíba");
        endereco1.setNumero(94);
        endereco1.setComplemento("AP101");
        endereco1.setLogradouro("Rua 01");
        endereco1.setPais("Brasil");


        Endereco endereco2 = new Endereco();
        endereco2.setCep("58038370");
        endereco2.setTipo(2);
        endereco2.setCidade("João Pessoa");
        endereco2.setEstado("Paraíba");
        endereco2.setNumero(104);
        endereco2.setComplemento("AP102");
        endereco2.setLogradouro("Rua 02");
        endereco2.setPais("Brasil");


        Cliente cliente1 = new Cliente();
        cliente1.setNome("Breno");
        cliente1.setCpf("113.167.544-48");
        cliente1.getContatos()[0] = contato1;
        cliente1.getEnderecos()[0] = endereco1;

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Diogo");
        cliente2.setCpf("123.456.789-48");
        cliente2.getContatos()[1] = contato2;
        cliente2.getEnderecos()[1] = endereco2;

        System.out.println("------------------------------");
        System.out.println("Imprimindo dados do cliente 1");
        cliente1.imprimirContato();
        cliente1.imprimirEndereco();
        cliente1.imprimirCliente();

        System.out.println("\n");

        System.out.println("------------------------------");
        System.out.println("Imprimindo dados do cliente 2");
        cliente2.imprimirContato();
        cliente2.imprimirEndereco();
        cliente2.imprimirCliente();


        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.setNumeroConta("123");
        contaCorrente1.setAgencia("331");
        contaCorrente1.setCliente(cliente1);
        contaCorrente1.setSaldo(20000.00);
        contaCorrente1.setChequeEspecial(100.00);
        System.out.println("\n");

        contaCorrente1.sacar(500);
        System.out.println("\n");
        System.out.println("0 saldo com cheque especial da conta corrente 1 é: "+contaCorrente1.retornarSaldoComChequeEspecial());
        System.out.println("\n");
        contaCorrente1.imprimir();


        ContaPoupanca contaPoupanca1 = new ContaPoupanca();
        contaPoupanca1.setNumeroConta("345");
        contaPoupanca1.setAgencia("335");
        contaPoupanca1.setCliente(cliente2);
        contaPoupanca1.setSaldo(1000.00);


        System.out.println("\n");
        contaPoupanca1.creditarTaxa();
        contaPoupanca1.imprimir();


    }
}