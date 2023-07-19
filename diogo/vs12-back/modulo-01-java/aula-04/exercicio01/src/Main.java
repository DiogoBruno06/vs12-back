public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Diogo");
        pessoa1.setSobrenome("Bruno");
        pessoa1.setIdade(15);
        pessoa1.setWhatsapp("986060610");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Breno");
        pessoa2.setSobrenome("Franco");
        pessoa2.setIdade(20);
        pessoa2.setWhatsapp("9234160610");

        Pessoa pessoa3 = new Pessoa("Diego","Bruno");
        pessoa3.setIdade(31);
        pessoa3.setWhatsapp("988141402");

        pessoa1.conversar(pessoa2);
        System.out.println("\n");
        System.out.println(pessoa1.retornarNomeCompleto());
        System.out.println(pessoa2.ehMaiorIdade(pessoa1));
        System.out.println(pessoa3.retornarNomeCompleto());
        pessoa1.mandarWhatsapp(pessoa2,"Olá boa tarde");



    }
}