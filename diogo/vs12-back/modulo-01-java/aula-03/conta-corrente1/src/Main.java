public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Contato contato1 = new Contato();
        contato1.descricao = "Contato para Diogo Bruno";
        contato1.telefone = "986060610";
        contato1.tipo = 1;


        Contato contato2 = new Contato();
        contato2.descricao = "Bruno Diogo";
        contato2.telefone = "912334456";
        contato2.tipo = 2;


        Endereco endereco1 = new Endereco();
        endereco1.cep = "58038270";
        endereco1.tipo = 1;
        endereco1.cidade = "João Pessoa";
        endereco1.estado = "Paraíba";
        endereco1.numero = 94;
        endereco1.complemento = "AP101";
        endereco1.logradouro = "Rua 01";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.cep = "58038370";
        endereco2.tipo = 2;
        endereco2.cidade = "João Pessoa";
        endereco2.estado = "Paraíba";
        endereco2.numero = 104;
        endereco2.complemento = "AP102";
        endereco2.logradouro = "Rua 02";
        endereco2.pais = "Brasil";

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Breno";
        cliente1.cpf = "113.167.544-48";
        cliente1.contatos[0] = contato1;
        cliente1.enderecos[0] = endereco1;

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Diogo";
        cliente2.cpf = "123.456.789-48";
        cliente2.contatos[1] = contato2;
        cliente2.enderecos[1] = endereco1;

        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "12345";
        contaCorrente1.agencia = 7890;
        contaCorrente1.saldo = 1000.0;
        contaCorrente1.chequeEspecial = 500.0;

        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.cliente = cliente2;
        contaCorrente2.numeroConta = "12345";
        contaCorrente2.agencia = 12432;
        contaCorrente2.saldo = 5500.00;
        contaCorrente2.chequeEspecial = 500.0;

        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.depositar(600);
        contaCorrente2.sacar(100);
        System.out.println("O saldo da conta 2 mais o cheque especial é: "+contaCorrente2.retornarSaldoComChequeEspecial());
        System.out.println("O saldo da conta 1 é: "+contaCorrente1.saldo);
        System.out.println("O saldo da conta 2 é: "+contaCorrente2.saldo);
        contaCorrente1.transferir(contaCorrente2,300);

    }
}