import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        double nota1 = teclado.nextDouble();

        System.out.println("Digite a segunda nota: ");
        double nota2 = teclado.nextDouble();

        System.out.println("Digite a terceira nota: ");
        double nota3 = teclado.nextDouble();

        double ME = (nota1 + nota2 + nota3) / 3;
        double MA = (nota1 + (nota2 * 2) + (nota3 * 3) + ME) / 7;

        System.out.printf("A media de exercicio é: %.2f", ME);
        System.out.printf("\n");
        System.out.printf("A media de aproveitamento é: %.2f", MA);
        System.out.printf("\n");

        if (MA > 9.0){
            System.out.println("O conceito é A");
            System.out.println("APROVADO");
        } else if (MA < 9.0 && MA > 7.5) {
            System.out.println("O conceito é B");
            System.out.println("APROVADO");
        } else if (MA < 7.5 && MA > 6.0) {
            System.out.println("O conceito é C");
            System.out.println("APROVADO");
        } else if (MA < 6.0 && MA > 4.0) {
            System.out.println("O conceito é D");
            System.out.println("REPROVADO");
        } else {
            System.out.println("O conceito é E");
            System.out.println("REPROVADO");
        }
    }
}
