public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public Integer agencia;
    public Double saldo;
    public Double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.printf("Nome do cliente: "+ cliente.nome);
        System.out.println("\n");
        System.out.printf("Número do cpf: "+ cliente.cpf);
        System.out.println("\n");
        System.out.printf("Número da conta: %s, agência: %d, saldo: %.2f, cheque especial: %.2f",numeroConta,agencia,saldo,chequeEspecial);
        System.out.println("\n");
    }

    public boolean sacar(double valor){
        if (valor > saldo){
            System.out.println("Saldo insuficiente");
            return false;
        }

        saldo -= valor;
        System.out.println("Saque feito!");
        return true;
    }

    public boolean depositar(double valor){
        if (valor <= 0){
            System.out.println("Digite um número valido");
            return false;
        }

        saldo += valor;
        System.out.println("Deposito realizado");
        return true;
    }

    public double retornarSaldoComChequeEspecial(){
        return  saldo + chequeEspecial;
    }

    public boolean transferir (ContaCorrente contaCorrente, double valor){
        if (valor > saldo){
            System.out.println("Saldo insuficiente para realizar a transferencia");
            return false;
        }

        saldo -= valor;
        contaCorrente.depositar(valor);
        System.out.println("Transferencia realizada com sucesso");
        return true;
    }

}
