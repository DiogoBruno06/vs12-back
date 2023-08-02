package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "986060610", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "998654954", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "998654995", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "986069032", "Contato para Charles"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "986053069", "Contato para Charles"));
    }

    public Contato create(Contato contato) {
        contato.setIdPessoa(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) {
        contatoAtualizar.setIdContato(contatoAtualizar.getIdContato());
        contatoAtualizar.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoAtualizar.setTipoContato(contatoAtualizar.getTipoContato());
        contatoAtualizar.setNumero(contatoAtualizar.getNumero());
        contatoAtualizar.setDescricao(contatoAtualizar.getDescricao());
        return contatoAtualizar;
    }

    public List<Contato> listById(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .collect(Collectors.toList());
    }

}


