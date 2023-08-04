package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService){
        this.pessoaService = pessoaService;
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws Exception{
        Pessoa pessoa = pessoaService.list().stream()
                .filter(x  -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id,Endereco endereco) throws Exception{
        return enderecoRepository.update(id,endereco);
    }

    public void delete(Long id) throws Exception {
        enderecoRepository.delete(id);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa){
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    private Endereco getEndereco(Integer id) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado!"));
        return enderecoRecuperado;
    }
}
