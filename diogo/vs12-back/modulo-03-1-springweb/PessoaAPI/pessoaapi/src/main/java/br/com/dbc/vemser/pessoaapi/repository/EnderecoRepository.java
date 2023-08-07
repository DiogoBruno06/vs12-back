package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    private static List<Endereco> enderecoList = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaRepository pessoaRepository;


    public EnderecoRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.COMERCIAL, "Avenida 01", 93, "AP 202", "58038-270", "João Pessoa", "Paraíba", "Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),2, TipoEndereco.RESIDENCIAL, "Avenida 03", 120, "AP 301", "58908-301", "João Pessoa", "Paraíba", "Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),4, TipoEndereco.COMERCIAL, "Avenida 02", 90, "AP 401", "58029-605", "João Pessoa", "Paraíba", "Brasil"));
        enderecoList.add(new Endereco(COUNTER.incrementAndGet(),3, TipoEndereco.COMERCIAL, "Avenida 05", 91, "AP 502", "58029-605", "João Pessoa", "Paraíba", "Brasil"));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecoList.add(endereco);
        return endereco;
    }

    ;

    public List<Endereco> list() {
        return enderecoList;
    }

    public void delete(Endereco endereco){
        enderecoList.remove(endereco);
    }

    public Endereco update(Integer idEndereco,
                          Endereco endereco) throws RegraDeNegocioException{
        Endereco enderecoAtualizado = enderecoList.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        enderecoAtualizado.setTipo(endereco.getTipo());
        enderecoAtualizado.setLogradouro(endereco.getLogradouro());
        enderecoAtualizado.setNumero(endereco.getNumero());
        enderecoAtualizado.setComplemento(endereco.getComplemento());
        enderecoAtualizado.setCep(endereco.getCep());
        enderecoAtualizado.setCidade(endereco.getCidade());
        enderecoAtualizado.setEstado(endereco.getEstado());
        enderecoAtualizado.setPais(endereco.getPais());
        return enderecoAtualizado;
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoList.stream()
                .filter(endereco -> idPessoa.equals(endereco.getIdPessoa()))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoList.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
               .collect(Collectors.toList());
    }
}
