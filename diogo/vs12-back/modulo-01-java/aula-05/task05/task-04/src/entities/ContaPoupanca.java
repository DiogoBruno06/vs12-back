package entities;

import interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(){

    }
    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public static double getJurosMensal(){
        return ContaPoupanca.JUROS_MENSAL;
    }

    public void creditarTaxa(){
        System.out.println("O credito taxa é: "+getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.printf("O nome do cliente é: %s",getCliente().getNome());
        System.out.println("\n");
        System.out.printf("O número da conta é %s, a agencia é: %s, e o saldo: %.2f",getNumeroConta(),getAgencia(),getSaldo());
    }
}
