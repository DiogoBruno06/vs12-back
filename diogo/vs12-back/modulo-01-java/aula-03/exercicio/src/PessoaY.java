public class PessoaY {
    public String nome;
    public String sobrenome;
    public int idade;
    public String whatsapp;

    public Boolean ehMaiorIdade(PessoaX pessoaX){
        if (pessoaX.idade > 18){
            return true;
        } else {
            return false;
        }
    }

    public void mandarWhatsapp(PessoaX pessoaX,String mensagem){
        System.out.printf("%s enviou: mensagem para %s",this.nome,pessoaX.nome);
    }
}
