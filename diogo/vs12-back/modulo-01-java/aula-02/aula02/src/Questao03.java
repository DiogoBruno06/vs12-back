
import java.util.Scanner;

public class Questao03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome = "";
        double peso = 0;
        double altura = 0;
        int idade = 0;

        int quantidade = 0;
        int idadeVelho = 0;
        double maiorAltura = 0;
        double maiorPeso = 0;
        double alturas = 0;


        do {
            System.out.println("Digite o nome: ");
            nome = teclado.next();

            if (!nome.equals("SAIR")) {
                System.out.println("Digite a altura: ");
                altura = teclado.nextDouble();

                System.out.println("Digite a idade: ");
                idade = teclado.nextInt();

                System.out.println("Digite o peso: ");
                peso = teclado.nextDouble();

                if (peso > maiorPeso) {
                    maiorPeso = peso;
                }

                if (idade > idadeVelho) {
                    idadeVelho = idade;
                }

                if (altura > maiorAltura){
                    maiorAltura = altura;
                }

                alturas += altura;
                quantidade++;
            }
        } while (!nome.equals("SAIR")) ;

            double media = alturas / quantidade;

        System.out.println("A quantidade de jogadores cadastrados é: "+quantidade);
        System.out.println("A altura do jogador mais alto é: "+maiorAltura);
        System.out.println("O jogador mais velho tem: "+idadeVelho);
        System.out.println("O jogador mais pesado tem: "+maiorPeso);
        System.out.println("A media das alturas é: "+media);
        }
    }
