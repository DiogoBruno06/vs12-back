public class Pessoa {
    public String nome;
    public String sobrenome;
    public int idade;
    public String whatsapp;


    public void conversar(Pessoa pessoa){
        System.out.printf("%s conversou com %s",this.nome, pessoa.nome);
    }

    public String retornarNomeCompleto(){
        return nome + " " + sobrenome;
    }

    public Boolean ehMaiorIdade(Pessoa pessoa){
        if (pessoa.idade > 18){
            System.out.println("A pessoa é maior de idade");
            return true;
        } else {
            System.out.println("A pessoa é menor de idade");
            return false;
        }
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem){
        System.out.printf("%s enviou: %s para %s",this.nome,mensagem, pessoa.nome);
    }
}
