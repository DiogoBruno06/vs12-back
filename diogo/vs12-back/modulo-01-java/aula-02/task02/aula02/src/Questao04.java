import java.util.Scanner;

public class Questao04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[][] matriz = new int [5][4];


        for (int i = 0; i < matriz.length; i++ ){
            System.out.println("Digite a matricula: ");
            int matricula = teclado.nextInt();
            matriz[i][0] = matricula;

            System.out.println("Digite a media das provas: ");
            int mediaProva = teclado.nextInt();
            matriz[i][1] = mediaProva;

            System.out.println("Digite a media dos trabalhos: ");
            int mediaTrabalho = teclado.nextInt();
            matriz[i][2] = mediaTrabalho;

            int mediaFinal = (int)(mediaProva * 0.6) + (int)(mediaTrabalho * 0.4);
            matriz[i][3] = mediaFinal;
        }

        double maiorNota = matriz[0][3];
        int matriculaNota = matriz[0][0];
        int somaNotas = 0;

        for (int i = 1; i < matriz.length; i++){
            if (matriz[i][3] > maiorNota){
                maiorNota = matriz[i][3];
                matriculaNota = matriz[i][0];
            }
        }


        for (int i = 1; i < matriz.length; i++){
           somaNotas += matriz[i][3];
        }

        int mediaNotas = somaNotas / matriz.length;

        System.out.println("A matricula com a maior nota é: " + matriculaNota);

        System.out.println("A media das notas finais é: "+mediaNotas);


    }
   }


