package br.com.dbccompany.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    ArrayList<Contato> contatos = new ArrayList<>();
    ArrayList<Endereco> enderecos = new ArrayList<>();
    Contato contato1 = new Contato("Contato para diogo", "986060610", 1);
    Endereco endereco1 = new Endereco(1, "Rua 01", 94, "AP 101", "58083270", "João Pessoa", "PB", "Brasil");
    Cliente cliente1 = new Cliente("Diogo", "113.142.135-49", contatos, enderecos);

    ContaCorrente contaCorrente = new ContaCorrente(cliente1, "2002", "132", 2000.00, 300.00);

    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1, "123", "321", 800.00);

    ContaPagamento contaPagamento = new ContaPagamento(cliente1, "321", "2003", 1000.00);

    Conta conta = new Conta(cliente1, "323", "132", 200.00);


    @Test
    @DisplayName("Questão 1")
    void TestaSaqueContaCorrenteEVerificaSaldo() {
        boolean testaSaque = contaCorrente.sacar(100);
        Assertions.assertEquals(true,testaSaque);
        double saldoSaque = contaCorrente.getSaldo();
        System.out.println("");
        System.out.println(saldoSaque);
    }

    @Test
    @DisplayName("Questão 2")
    void TestarSaqueContaCorrenteSemSaldo() {
        boolean valor = contaCorrente.depositar(contaCorrente.getChequeEspecial());
        boolean testaSaque2 = contaCorrente.sacar(30000);
        Assertions.assertEquals(false,testaSaque2);

    }

    @Test
    @DisplayName("Questão 3")
    void TestarSaqueContaPoupancaEVerificarSaldo() {
       boolean testaSaque = contaPoupanca.sacar(300);
        System.out.println("");
       contaPoupanca.creditarTaxa();
       Assertions.assertEquals(true,testaSaque);
       double saldoSaque = contaPoupanca.getSaldo();
       System.out.println("");
       System.out.println("O saldo restante é: "+saldoSaque);
    }

    @Test
    @DisplayName("Questão 4")
    void TestarSaqueContaPoupancaSemSaldo(){
        boolean testaSaque = contaPoupanca.sacar(1200);
        Assertions.assertEquals(false,testaSaque);

    }

    @Test
    @DisplayName("Questão 5")
    void TestaSaqueContaPagamentoSucesso(){
        boolean testaSaque = contaPagamento.sacar(400);
        Assertions.assertEquals(true,testaSaque);
        double saldoSaque = contaPagamento.getSaldo();
        System.out.println("O saldo restante é: "+saldoSaque);
    }

    @Test
    @DisplayName("Questão 6")
    void TestaSaqueContaPagamentoSemSaldo(){
        boolean testaSaque = contaPagamento.sacar(5000);
        Assertions.assertEquals(false,testaSaque);
    }
    @Test
    @DisplayName("Questão 7")
    void TestarTransferenciaEVerificarSaldoComSucesso(){
        boolean testaTransferencia = contaPagamento.transferir(contaCorrente,300);
        Assertions.assertEquals(true, testaTransferencia);
        double saldoSaque = contaPagamento.getSaldo();
        System.out.println("O saldo restante é: "+saldoSaque);
    }

    @Test
    @DisplayName("Questão 8")
    void TestarTransferenciaSemSaldo(){
        boolean testaTransferencia = contaPagamento.transferir(contaCorrente,1200);
        Assertions.assertEquals(false,testaTransferencia);
    }

    @Test
    @DisplayName("Questão 9")
    void TestaDepositoEVerificaSaldo(){
        boolean testaDeposito = contaCorrente.depositar(500);
        Assertions.assertEquals(true,testaDeposito);
    }

    @Test
    @DisplayName("Questão 10")
    void TestaDepositoNegativo(){
        boolean testaDeposito = contaCorrente.depositar(-1);
        Assertions.assertEquals(false,testaDeposito);
    }
}