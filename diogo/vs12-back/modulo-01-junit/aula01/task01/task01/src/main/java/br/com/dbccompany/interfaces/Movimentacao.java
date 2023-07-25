package br.com.dbccompany.interfaces;


import br.com.dbccompany.entities.Conta;

public interface Movimentacao {
     boolean sacar(double valor);
     boolean depositar(double valor);
     boolean transferir(Conta conta, double valor);
}
