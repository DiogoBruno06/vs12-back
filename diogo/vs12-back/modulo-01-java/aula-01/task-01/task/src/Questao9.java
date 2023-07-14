import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a data, hora e minuto de entrada seguindo o pattern dd--mm-yyyy T hh:mm");
        LocalDateTime entrada = LocalDateTime.parse(teclado.next());
        System.out.println("Digite a data, hora e minuto de saida seguindo o pattern dd--mm-yyyy T hh:mm");
        LocalDateTime saida = LocalDateTime.parse(teclado.next());

        Duration diferenca = Duration.between(entrada,saida);

        System.out.println("A diferença entre as datas é: "+diferenca.toString());
    }
}
