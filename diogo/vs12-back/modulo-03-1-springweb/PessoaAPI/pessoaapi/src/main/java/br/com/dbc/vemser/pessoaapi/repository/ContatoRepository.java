package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import org.springframework.stereotype.Repository;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    private final PessoaRepository pessoaRepository;

    public ContatoRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "986060610", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "998654954", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "998654995", "Contato para Maicon"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "986069032", "Contato para Charles"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "986053069", "Contato para Charles"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }
    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Long id) throws Exception {
        Contato contato = listaContatos.stream()
                .filter(x -> x.getIdContato() == id.longValue())
                .findFirst().orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contato);
    }

    public Contato update(Integer id,
                         Contato contato) throws Exception{
        Contato contatoAtualizado = listaContatos.stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoAtualizado.setIdContato(COUNTER.incrementAndGet());
        contatoAtualizado.setIdPessoa(contato.getIdPessoa());
        contatoAtualizado.setTipoContato(contato.getTipoContato());
        contatoAtualizado.setNumero(contato.getNumero());
        contatoAtualizado.setDescricao(contato.getDescricao());
        return contatoAtualizado;
    }
    public List<Contato> listById(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}


