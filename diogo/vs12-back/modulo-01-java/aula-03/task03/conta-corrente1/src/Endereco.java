public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco() {

        System.out.printf("O logradouro é: %s,o número da residencia é: %d, o complemento é: %s,o CEP é: %s,a cidade onde reside é: %s,o estado é: %s e o país é %s%n",
                this.logradouro, this.numero, this.complemento, this.cep, this.cidade, this.estado, this.pais);
        System.out.printf("Tipo: %d%n", this.tipo);
    }
}
