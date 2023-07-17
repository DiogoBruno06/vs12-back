import java.util.Scanner;

public class Questao02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o número certo: ");
        int numeroCerto = teclado.nextInt();

        System.out.println("Digite o número para tentar adivinhar: ");
        int numero = teclado.nextInt();


        while (numero != numeroCerto){
            System.out.println("Número errado!");
            System.out.println("Digite um número: ");
            numero = teclado.nextInt();
            if (numero < numeroCerto){
                System.out.println("O número digitado é menor que o certo");
            } else if (numero > numeroCerto){
                System.out.println("O número digitado é maior que o certo");
            } else {
                System.out.println("Número certo!");
            }
        }

    }
}
