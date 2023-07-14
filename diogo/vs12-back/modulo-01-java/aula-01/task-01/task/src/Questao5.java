import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a altura");
        double altura = teclado.nextDouble();

        System.out.println("Digite a base");
        double base = teclado.nextDouble();

        double area = base * altura;

        System.out.println("A área do retangulo é: "+area);


    }
}
