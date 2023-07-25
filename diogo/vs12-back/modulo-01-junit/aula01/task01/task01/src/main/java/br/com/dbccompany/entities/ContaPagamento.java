package br.com.dbccompany.entities;

import br.com.dbccompany.interfaces.Impressao;


public class ContaPagamento extends Conta implements Impressao {
    private static double TAXA_SAQUE =  4.25;

    public ContaPagamento(){

    }
    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (getSaldo() <= 0 ){
            System.out.println("Voce não pode deixar a conta vazia");
            return false;
        }
        if (valor > getSaldo()){
            System.out.println("Você não pode fazer um saque de um valor que você não tem");
            return false;
        }

        System.out.println("\n");
        System.out.println("O valor com a taxa de saque é: "+ TAXA_SAQUE * getSaldo());
        return true;
    }

    @Override
    public void imprimir() {
        System.out.printf("O nome do cliente é: %s",getCliente().getNome());
        System.out.println("\n");
        System.out.printf("O número da conta é %s, a agencia é: %s, e o saldo: %.2f",getNumeroConta(),getAgencia(),getSaldo());
    }


}
