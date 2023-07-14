import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a hora da entrada");
        int horaEntrada = teclado.nextInt();

        if (horaEntrada > 24){
            System.out.println("O dia não tem mais de 24 horas");
            horaEntrada = 0;
        }

        System.out.println("Digite os minutos da entrada");
        int minutoEntrada = teclado.nextInt();

        if (minutoEntrada > 59){
            System.out.println("Não existe minuto acima de 59");
            minutoEntrada = 0;
        }

        System.out.println("Digite a hora de saida");
        int horaSaida = teclado.nextInt();

        if (horaSaida > 24){
            System.out.println("O dia não tem mais de 24 horas");
            horaSaida = 0;
        }

        System.out.println("Digite o minuto da saida");
        int minutoSaida = teclado.nextInt();

        if (minutoSaida > 59){
            System.out.println("Não existe minuto acima de 59");
            minutoSaida = 0;
        }

        int diferencaHora = horaSaida - horaEntrada + ((horaEntrada < horaSaida) ? 0 : 24);
        System.out.println("A diferença entre as horas foi: "+diferencaHora);

        int diferencaMinuto = minutoSaida - minutoEntrada;
        if (minutoEntrada > minutoSaida){
            diferencaMinuto = (minutoSaida + minutoEntrada) % 60;
            System.out.println("A diferença entre os minutos: "+diferencaMinuto);
        } else {
            System.out.println("A diferença entre os minutos: "+diferencaMinuto);
        }
    }
}
