public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.nome = "Diogo";
        pessoa1.sobrenome = "Bruno";
        pessoa1.idade = 15;
        pessoa1.whatsapp = "986060610";

        Pessoa pessoa2 = new Pessoa();
        pessoa2.nome = "Breno";
        pessoa2.sobrenome = "Franco";
        pessoa2.idade = 20;
        pessoa2.whatsapp = "9234160610";

        pessoa1.conversar(pessoa2);
        System.out.println("\n");
        System.out.println(pessoa1.retornarNomeCompleto());
        System.out.println(pessoa2.ehMaiorIdade(pessoa1));
        pessoa1.mandarWhatsapp(pessoa2,"Olá boa tarde");

    }
}