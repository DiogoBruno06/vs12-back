
import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String nome = teclado.next();

        System.out.println("Digite o valor do produto: ");
        double preco = teclado.nextDouble();

        double precoFinal = preco;
        double precoUnidade = 0;
        double desconto = 0.05;


        System.out.println("Produto: "+nome);
        System.out.println("Preço: "+precoFinal);
        System.out.println("Promoção: "+nome);
        System.out.println("-----------------------");
        for (int i = 1; i <= 10; i++){
            preco = precoFinal - (precoFinal * desconto);
            desconto = desconto + 0.05;
            precoUnidade = preco * i;
            System.out.printf("\n"+i+" x R$: %.2f" + " = R$ %.2f",preco,precoUnidade);
        }
    }
}
