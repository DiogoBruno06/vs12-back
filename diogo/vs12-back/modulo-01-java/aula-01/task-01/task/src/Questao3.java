import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a palavra / Write the word");
        String resp = teclado.next();

        switch (resp) {
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Sad":
                System.out.println("Triste");
                break;
            case "Triste":
                System.out.println("Sad");
                break;
            case "Should":
                System.out.println("Deveria");
                break;
            case "Deveria":
                System.out.println("Should");
                break;
            case "Could":
                System.out.println("Poderia");
                break;
            case "Poderia":
                System.out.println("Could");
                break;
            default:
                System.out.println("Essa palavra não é valida");
        }
    }
}
