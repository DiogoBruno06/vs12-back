import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a quantidade de eleitores");
        int eleitores = teclado.nextInt();

        System.out.println("Digite quantos votos brancos foram feitos");
        int brancos = teclado.nextInt();

        if (brancos > eleitores) {
            System.out.println("Você não pode ter mais números do que eleitores");
        }

        System.out.println("Digite a quantidade de votos nulos: ");
        int nulos = teclado.nextInt();

        if (nulos > eleitores) {
            System.out.println("Você não pode ter mais números do que eleitores");
        }

        System.out.println("Digite a quantidade de votos validos");
        int validos = teclado.nextInt();

        if (validos > eleitores) {
            System.out.println("Você não pode ter mais números do que eleitores");
        }

        double percentualBrancos = (brancos * 100 / eleitores);
        double percentualNulos = (nulos * 100 / eleitores);
        double percentualValidos = (validos * 100 / eleitores);

        System.out.println("O percentual de votos brancos é: " + percentualBrancos);
        System.out.println("O percentual de votos nulos é: " + percentualNulos);
        System.out.println("O percentual de votos validos é: " + percentualValidos);
    }
}
