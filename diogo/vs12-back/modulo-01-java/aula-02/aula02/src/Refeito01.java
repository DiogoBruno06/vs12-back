import java.util.Scanner;

public class Refeito01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] valores = new int[3];
        int soma = 0;
        int divisao = 0;
        for (int i = 0; i < valores.length; i++){
            System.out.println("Digite o número: ");
            valores[i] = teclado.nextInt();

            soma += valores[i];
            divisao = soma / valores.length;
        }
        System.out.println("A soma do valores foi: "+soma);
        System.out.println("A divisão dos valores foi: "+divisao);
    }
}
