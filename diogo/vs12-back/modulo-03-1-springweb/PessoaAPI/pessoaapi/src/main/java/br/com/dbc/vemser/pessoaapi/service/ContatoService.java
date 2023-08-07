package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService, ObjectMapper objectMapper){
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }
    public ContatoDTO create(ContatoCreateDTO contato) throws RegraDeNegocioException{
        Contato entity = objectMapper.convertValue(contato,Contato.class);
        entity.setDescricao(contato.getDescricao());
        entity.setNumero(contato.getNumero());
        entity.setTipoContato(contato.getTipoContato());
        entity.setIdPessoa(contato.getIdPessoa());

        Contato contato1 = contatoRepository.create(entity);

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setIdContato(contato1.getIdContato());
        contatoDTO.setTipoContato(contato1.getTipoContato());
        contatoDTO.setNumero(contato1.getNumero());
        contatoDTO.setDescricao(contato1.getDescricao());
        contatoDTO.setIdPessoa(contato1.getIdPessoa());

        return contatoDTO;
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id,Contato contatoAtualizado) throws RegraDeNegocioException{
        return contatoRepository.update(id, contatoAtualizado);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.delete(id);
    }
    public List<Contato> listById(Integer idPessoa) {
        return contatoRepository.listById(idPessoa);
    }

    private Contato getContato(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
