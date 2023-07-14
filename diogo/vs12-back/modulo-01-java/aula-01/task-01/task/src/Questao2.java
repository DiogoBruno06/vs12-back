import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Escolha entre esses 3 estados: 1 = PB,2 = RS,3 = SC");
        char resp = teclado.nextLine().charAt(0);

        if (resp == '1') {
            System.out.println("Escolha entre 1 = CG ou 2 = PB");
            char rp = teclado.nextLine().charAt(0);
            if (rp == '1') {
                System.out.println("População: 419.379 pessoas,principal festa: São João,IDH:0,500 – 0,599");
            } else if (rp == '2'){
                System.out.println("População: 825.800 pessoas, principal festa: Carnaval,IDH: 0,763 ");
            } else {
                System.out.println("Opção Invalida");
            }
        } else if (resp == '2') {
            System.out.println("Escolha entre 1 = POA ou 2 = CXJ");
            char rp = teclado.nextLine().charAt(0);
            if (rp == '1') {
                System.out.println("População: 1.332.570 habitantes, principal festa: Gre-Nal, IDH: 0,805");
            } else if (rp == '2'){
                System.out.println("População: 463.338 pessoas, principal festa: Festa da Uva, IDH: 0,782");
            } else {
                System.out.println("Opção Invalida");
            }
        } else if (resp == '3') {
            System.out.println("Escolha entre 1 = FLP ou 2 = BC");
            char rp = teclado.nextLine().charAt(0);
            if (rp == '1') {
                System.out.println("População: 537.213 pessoas, principal festa: Festa dos Reis, IDH: 0,847");
            }
            if (rp == '2') {
                System.out.println("População: 139.155 pessoas, principal festa: Reveillon, IDH: 0,845");
            } else {
                System.out.println("Opção Invalida");
            }
        } else {
                System.out.println("Opção Invalida");
            }
        }
    }
