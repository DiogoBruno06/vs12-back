package entities;

import interfaces.Movimentacao;

public class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(){

    }
    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > saldo){
            System.out.println("Saldo insuficiente");
            return false;
        }

        saldo -= valor;
        System.out.println("Saque feito!");
        System.out.printf("O valor de: %.2f foi retirado da conta", valor);
        return true;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor <= 0){
            System.out.println("Digite um número valido");
            return false;
        }

        saldo += valor;
        System.out.println("\n");
        System.out.printf("Deposito de %.2f foi realizado",valor);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor > saldo){
            System.out.println("Saldo insuficiente para realizar a transferencia");
            return false;
        }

        saldo -= valor;
        conta.depositar(valor);
        System.out.println("\n");
        System.out.println("Transferencia realizada com sucesso");
        return true;
    }
}
