package br.com.dbccompany;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario {
    String nome;
    LocalDate dataNascimento;
    LocalDate dataContratacao;
    double salario;

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public int calcularTempoDeEmpresa(){
        return Period.between(dataContratacao, LocalDate.now()).getYears();
    }
    public Funcionario(){

    }
    public Funcionario(String nome, String dataNascimento, String dataContratacao, double salario) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.dataContratacao = LocalDate.parse(dataContratacao);
        this.salario = salario;
    }

}
