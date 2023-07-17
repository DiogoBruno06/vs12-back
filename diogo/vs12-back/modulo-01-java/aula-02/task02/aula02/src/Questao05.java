import java.util.Scanner;

public class Questao05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[][] matriz = new int[10][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Mercado " + (1 + j) + ": Valor:  ");
                double valor = teclado.nextDouble();
                matriz[i][j] = (int)valor;
            }
        }

        int somaPreco[] = new int[3];

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                somaPreco[j] += matriz[i][j];
            }
        }

        int mercados = 0;
        for (int i = 1; i < somaPreco.length; i++){
            if (somaPreco[i] < somaPreco[mercados]){
                mercados = i;
            }
        }

        System.out.println("O mercado mais barato é: "+ (mercados+ 1));
    }
}
