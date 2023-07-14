import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o salario: ");
        double salario = teclado.nextDouble();

        System.out.println("Digite o cargo: ");
        String cargo = teclado.next();

        switch (cargo) {
            case "Gerente": {
                double novoSalario = salario + (salario * 0.10);
                System.out.println("O novo salario é: " + novoSalario);
                System.out.println("O antigo salario é: " + salario);
                System.out.printf("A diferença é de: %.2f ", novoSalario - salario);
            }
            case "Engenheiro": {
                double novoSalario = salario + (salario * 0.20);
                System.out.println("O novo salario é: " + novoSalario);
                System.out.println("O antigo salario é: " + salario);
                System.out.printf("A diferença é de: %.2f ", novoSalario - salario);
            }
            case "Técnico": {
                double novoSalario = salario + (salario * 0.30);
                System.out.println("O novo salario é: " + novoSalario);
                System.out.println("O antigo salario é: " + salario);
                System.out.printf("A diferença é de: %.2f ", novoSalario - salario);
            }
            default:
                double novoSalario = salario + (salario * 0.40);
                System.out.println("O novo salario é: " + novoSalario);
                System.out.println("O antigo salario é: " + salario);
                System.out.printf("A diferença é de: %.2f ", novoSalario - salario);
        }
    }
}
