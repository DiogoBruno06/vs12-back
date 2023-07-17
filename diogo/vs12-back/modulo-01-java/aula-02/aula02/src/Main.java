import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = {30,20,10};
        System.out.println(numeros[0]+numeros[1]+numeros[2]);
        System.out.println((numeros[0]+numeros[1]+numeros[2]) / 3);

        int[][] numeros2 = {{1, 2}, {3, 4}, {47,64}};

        System.out.println("-----Matriz------");
        for (int i = 0; i < numeros2.length; i++){
            for (int j = 0; j < numeros2[i].length; j++){
                System.out.println(numeros2[i][j]);
            }
            System.out.println("Fim da Linha");
        }

        System.out.println("----------FOR EACH---------");
        for (int numero : numeros){
            System.out.println(numero);
        }

        String[] frutas = {"Melão", "Banana", "Laranja"};

        for (String fruta : frutas){
            System.out.println(fruta);
        };


        System.out.println("Digite o tamanho do vetor: ");
        int tamanho = teclado.nextInt();
        int inteiros[];
        for (int i = 0; i < tamanho; i++){
            System.out.println("Digite número: ");
            int proxNumero = teclado.nextInt();;
            inteiros = new int[proxNumero];

        }


    }
}