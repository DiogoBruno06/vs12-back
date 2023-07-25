package br.com.dbccompany;

public class FuncionarioTeste {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Diogo","2004-10-06","2022-06-07",800);

        System.out.println(funcionario.calcularIdade());
        System.out.println(funcionario.calcularTempoDeEmpresa());
    }
}
