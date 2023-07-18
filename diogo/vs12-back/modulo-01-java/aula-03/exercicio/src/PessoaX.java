public class PessoaX {
    public String nome;
    public String sobrenome;
    public int idade;
    public String whatsapp;


    public void conversar(PessoaY pessoay){
        System.out.printf("%s conversou com %s",this.nome, pessoay.nome);
    }

    public String retornarNomeCompleto(){
        return nome + " " + sobrenome;
    }
}
