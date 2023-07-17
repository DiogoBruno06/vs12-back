import java.util.Scanner;

public class Questao06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < vetor.length;i++){
            vetor[i] = i + 1;
        }

        int[] novoVetor = new int[vetor.length + 1];

        System.out.println("Digite o novo número: ");
        int novoNumero = teclado.nextInt();
        for (int i = 0; i < vetor.length; i++){
            novoVetor[i] = vetor[i];
        }

        novoVetor[novoVetor.length - 1] = novoNumero;
        vetor = novoVetor;


        int contador = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == novoNumero) {
                contador++;
            }
        }

        int contaMenor = 0;
        for (int i = 0; i < vetor.length; i++){
            if (vetor[i] < novoNumero){
                contaMenor ++;
            }
        }

        int contaMaior = 0;
        for (int i = 0; i < vetor.length; i++){
            if (vetor[i] > novoNumero){
                contaMaior++;
            }
        }

        System.out.printf("O número se encontra %d no vetor",contador);
        System.out.println("\n");
        System.out.printf("Existem %d números menores que o número digitado",contaMenor);
        System.out.println("\n");
        System.out.printf("Existem %d números maiores que o número digitado",contaMaior);
    }
}
