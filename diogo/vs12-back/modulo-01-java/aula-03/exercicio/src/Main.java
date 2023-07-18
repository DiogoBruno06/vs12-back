public class Main {
    public static void main(String[] args) {

        PessoaX pessoaX = new PessoaX();
        pessoaX.nome = "Diogo";
        pessoaX.sobrenome = "Bruno";
        pessoaX.idade = 15;
        pessoaX.whatsapp = "986060610";

        PessoaY pessoaY = new PessoaY();
        pessoaY.nome = "Bruno";
        pessoaY.sobrenome = "Diogo";
        pessoaY.idade = 20;
        pessoaY.whatsapp = "9234160610";

        pessoaX.conversar(pessoaY);
        System.out.println("\n");
        System.out.println(pessoaX.retornarNomeCompleto());
        System.out.println(pessoaY.ehMaiorIdade(pessoaX));
        pessoaY.mandarWhatsapp(pessoaX,"Olá boa tarde");

    }
}