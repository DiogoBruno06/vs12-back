import entities.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();
        Contato contato1 = new Contato("Contato para diogo","986060610",1);
        Contato contato2 = new Contato("Contato para Lucas","985091320",2);

        contatos.add(contato1);
        contatos.add(contato2);

        Endereco endereco1 = new Endereco(1,"Rua 01",94,"AP 101","58083270","João Pessoa","PB","Brasil");
        Endereco endereco2 = new Endereco(2,"Rua 01",94,"AP 102","58083370","João Pessoa","PB","Brasil");


        enderecos.add(endereco1);
        enderecos.add(endereco2);

        Cliente cliente1 = new Cliente("Diogo","113.142.135-49",contatos,enderecos);
        Cliente cliente2 = new Cliente("Lucas", "135.144.134.89",contatos, enderecos);

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        for (Cliente cliente : listaClientes){
            cliente.imprimirCliente();
            System.out.println("\nInformações de contatos");
            cliente.imprimirContato();
            System.out.println("\nInformações de endereços");
            cliente.imprimirEndereco();
            System.out.println("\n ------------------------------ \n");
        }

        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "345", "334",1500.00, 200.00);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1,"551","951",2000.00);
        ContaPagamento contaPagamento = new ContaPagamento(cliente1,"331","961",1000.00);

        contaCorrente2.retornarSaldoComChequeEspecial();
        contaCorrente2.sacar(150);
        contaCorrente2.depositar(200);

        System.out.println("\n");
        System.out.printf("O saldo restante foi: %.2f",contaCorrente2.getSaldo());
        contaCorrente2.transferir(contaPoupanca,300);

        System.out.println("\n");
        System.out.printf("O saldo restante é: %.2f",contaCorrente2.getSaldo());

        contaPagamento.sacar(-1);
        System.out.println("\n");
        contaPagamento.getSaldo();
        contaPagamento.transferir(contaCorrente2,200);

        contaPagamento.depositar(250);
        contaPagamento.sacar(200);
        contaPagamento.transferir(contaCorrente2,200);


        contaCorrente2.imprimir();
        contaPoupanca.imprimir();
        contaPagamento.imprimir();





    }
}