package br.com.dbccompany.entities;

import br.com.dbccompany.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {
    private Double chequeEspecial;

    public ContaCorrente(){

    }
    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

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
