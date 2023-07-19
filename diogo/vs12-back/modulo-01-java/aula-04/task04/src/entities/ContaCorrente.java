package entities;

import interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {
    private Double chequeEspecial;

    public Double retornarSaldoComChequeEspecial(){
        return getSaldo() + this.chequeEspecial;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double valor) {
        this.chequeEspecial = valor;
    }

    @Override
    public boolean sacar(double valor) {
        return super.sacar(valor);
    }

    @Override
    public void imprimir() {
        System.out.printf("O nome do cliente é: %s",getCliente().getNome());
        System.out.println("\n");
        System.out.printf("O número da conta é %s, a agencia é: %s, e o saldo: %.2f",getNumeroConta(),getAgencia(),getSaldo());
    }


}
