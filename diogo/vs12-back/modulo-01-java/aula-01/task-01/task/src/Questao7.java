import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite qual produto deseja comprar");
        String resp = teclado.next();

        switch (resp) {
            case "ABCD": {
                System.out.println("Digite a quantidade que deseja: ");
                int quantidade = teclado.nextInt();
                double valor = quantidade * 5.30;
                System.out.printf("O codigo do produto é %s, a quantidade é %d, e o valor é %.2f", resp, quantidade, valor);
                break;
            }
            case "XYPK": {
                System.out.println("Digite a quantidade que deseja: ");
                int quantidade = teclado.nextInt();
                double valor = quantidade * 6.00;
                System.out.printf("O codigo do produto é %s, a quantidade é %d, e o valor é %.2f", resp, quantidade, valor);
                break;
            }
            case "KLMP": {
                System.out.println("Digite a quantidade que deseja: ");
                int quantidade = teclado.nextInt();
                double valor = quantidade * 3.20;
                System.out.printf("O codigo do produto é %s, a quantidade é %d, e o valor é %.2f", resp, quantidade, valor);
                break;
            }
            case "QRST": {
                System.out.println("Digite a quantidade que deseja: ");
                int quantidade = teclado.nextInt();
                double valor = quantidade * 2.50;
                System.out.printf("O codigo do produto é %s, a quantidade é %d, e o valor é %.2f", resp, quantidade, valor);
                break;
            }
            default:
                System.out.println("CODIGO INVÁLIDO");
        }
    }
}

