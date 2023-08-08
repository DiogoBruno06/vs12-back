package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService, ObjectMapper objectMapper){
        this.pessoaService = pessoaService;
        this.enderecoRepository = enderecoRepository;
        this.objectMapper = objectMapper;
    }

    public EnderecoDTO create(EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        Endereco entity = objectMapper.convertValue(endereco, Endereco.class);
        entity.setPais(endereco.getPais());
        entity.setEstado(endereco.getEstado());
        entity.setCep(endereco.getCep());
        entity.setNumero(endereco.getNumero());
        entity.setComplemento(endereco.getComplemento());
        entity.setLogradouro(endereco.getLogradouro());
        entity.setTipo(endereco.getTipo());
        entity.setIdPessoa(endereco.getIdPessoa());

        Endereco endereco1 = enderecoRepository.create(entity);

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setIdEndereco(endereco1.getIdEndereco());
        enderecoDTO.setPais(endereco1.getPais());
        enderecoDTO.setEstado(endereco1.getEstado());
        enderecoDTO.setCep(endereco1.getCep());
        enderecoDTO.setNumero(endereco1.getNumero());
        enderecoDTO.setComplemento(endereco1.getComplemento());
        enderecoDTO.setLogradouro(endereco1.getLogradouro());
        enderecoDTO.setTipo(endereco1.getTipo());
        enderecoDTO.setIdPessoa(endereco1.getIdPessoa());

        return enderecoDTO;
    }

    public Endereco update(Integer id,EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        return enderecoRepository.update(id,endereco);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = getEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa){
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException{
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado!"));
        return enderecoRecuperado;
    }
}
