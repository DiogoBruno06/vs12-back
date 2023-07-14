import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocalDateTime entrada = LocalDateTime.parse(teclado.next());
        LocalDateTime saida = LocalDateTime.parse(teclado.next());

        Duration diferenca = Duration.between(entrada,saida);

        System.out.println("A diferença entre as datas é: "+diferenca.toString());
    }
}
