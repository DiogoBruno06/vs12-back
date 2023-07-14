import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a altura");
        Double altura = teclado.nextDouble();

        System.out.println("Digite a base");
        Double base = teclado.nextDouble();

        Double area = base * altura;

        System.out.println(area);


    }
}
