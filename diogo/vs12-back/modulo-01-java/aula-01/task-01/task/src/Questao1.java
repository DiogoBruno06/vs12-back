import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = teclado.nextInt();

        System.out.print("Digite a sua cidade: ");
        teclado.nextLine();
        String cidade = teclado.nextLine();

        System.out.print("Digite o seu estado: ");
        String estado = teclado.nextLine();


        System.out.printf("Olá seu nome é: %s, você tem: %d anos, é da cidade de: %s, e que é situada no estado: %s", nome, idade, cidade, estado);


    }
}