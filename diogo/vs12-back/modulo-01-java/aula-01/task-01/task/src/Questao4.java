import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int soma = a - b;
        b += soma;
        a += b;


        System.out.println(a);
        System.out.println(b);

    }
}
