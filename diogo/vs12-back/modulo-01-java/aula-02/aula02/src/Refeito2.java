import java.util.Scanner;

public class Refeito2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[][] valores = new int[2][2];
        int somaTotal = 0;
        int somaSegundaLinha = 0;
        int somaPrimeiraLinha = 0;
        int subtracao = 0;

        for (int i = 0; i < valores.length; i++){
            somaPrimeiraLinha += valores[0][1];
            for (int j = 0; j < valores[i].length; j++){
                System.out.println("Digite os valores: ");
                valores[i][j] = teclado.nextInt();
                somaTotal += valores[i][j];
                somaPrimeiraLinha = valores[0][1] + valores[0][0];
                somaSegundaLinha = valores[1][0] + valores[1][1];
            }
        }
        subtracao = somaSegundaLinha - somaPrimeiraLinha;
        System.out.println("A soma total é: "+somaTotal);
        System.out.println("A soma da primeira linha é: "+somaPrimeiraLinha);
        System.out.println("A soma da segunda linha é: "+somaSegundaLinha);
        System.out.println("A subtração entre as linhas são: "+subtracao);
    }
}
