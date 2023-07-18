public class Contato {
    public String descricao;
    public String telefone;
    public Integer tipo;

    public void imprimirContrato(){
        System.out.printf("A descrição do contato é: %s, o telefone para contato é: %s, e o tipo é: %d%n",this.descricao,this.telefone,this.tipo);
    }
}
