public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private String whatsapp;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public void conversar(Pessoa pessoa){
        System.out.printf("%s conversou com %s",getNome(), pessoa.nome);
    }

    public String retornarNomeCompleto(){
        return getNome() + " " + getSobrenome();
    }

    public Boolean ehMaiorIdade(Pessoa pessoa){
        if (getIdade() > 18){
            System.out.println("A pessoa é maior de idade");
            return true;
        } else {
            System.out.println("A pessoa é menor de idade");
            return false;
        }
    }

    public void mandarWhatsapp(Pessoa pessoa, String mensagem){
        System.out.printf("%s enviou: %s para %s",getNome(),mensagem, pessoa.nome);
    }

    public Pessoa(){

    }

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
}
