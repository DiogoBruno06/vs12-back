import java.util.Scanner;

public class Refeito03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String palavra = "";

        do {
            System.out.println("Digite a palavra");
            palavra = teclado.next();
            System.out.println(palavra);
        } while (!palavra.equalsIgnoreCase("fim"));

    }
}
