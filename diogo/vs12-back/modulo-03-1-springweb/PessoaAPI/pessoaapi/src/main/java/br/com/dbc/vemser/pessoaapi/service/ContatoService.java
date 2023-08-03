package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService){
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }
    public Contato create(Integer idPessoa, Contato contato) throws Exception{
       Pessoa pessoa = pessoaService.list().stream()
               .filter(x  -> x.getIdPessoa().equals(idPessoa))
               .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
       contato.setIdPessoa(pessoa.getIdPessoa());
       return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id,Contato contato) throws Exception{
        return contatoRepository.update(id,contato);
    }

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listById(Integer idPessoa) {
        return contatoRepository.listById(idPessoa);
    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
