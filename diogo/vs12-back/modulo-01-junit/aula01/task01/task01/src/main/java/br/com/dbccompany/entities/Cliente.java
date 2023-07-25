package br.com.dbccompany.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente(){

    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirEndereco(){
        for (Endereco endereco : enderecos){
            if (endereco != null){
                System.out.println("-----------------");
                System.out.println("Pais: "+endereco.getPais());
                System.out.println("Estado: "+endereco.getEstado());
                System.out.println("Cidade: "+endereco.getCidade());
                System.out.println("CEP: "+endereco.getCep());
                System.out.println("Logradouro: "+endereco.getLogradouro());
                System.out.println("Complemento: "+endereco.getComplemento());
                System.out.println("Numero: "+endereco.getNumero());
                System.out.println("Tipo: "+endereco.getTipo());
            }
        }
    }

    public void imprimirContato(){
        for (Contato contato : contatos){
            if (contato != null){
                System.out.println("------------------");
                System.out.println("Tipo: "+ contato.getTipo());
                System.out.println("Telefone: "+contato.getTelefone());
                System.out.println("Descrição: "+contato.getDescricao());
            }
        }
    }

    public void imprimirCliente(){
        System.out.printf("O nome do cliente é: %s, o CPF é: %s",this.nome, this.cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }



}
