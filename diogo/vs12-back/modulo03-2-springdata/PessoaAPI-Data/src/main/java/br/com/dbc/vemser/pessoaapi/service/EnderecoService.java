package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;

    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";
    public void delete(Integer id) throws Exception {
        try {
            EnderecoEntity enderecoEntityRecuperado = findById(id);
            enderecoRepository.delete(enderecoEntityRecuperado);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

    public EnderecoDTO create(EnderecoCreateDTO enderecoEntity) {
        EnderecoEntity enderecoConverterEntity = converterDTO(enderecoEntity);
        return retornarDTO(enderecoRepository.save(enderecoConverterEntity));
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoDTO) throws Exception {
        EnderecoEntity enderecoEntityRecuperado = findById(id);

        enderecoEntityRecuperado.setCep(enderecoDTO.getCep());
        enderecoEntityRecuperado.setCidade(enderecoDTO.getCidade());
        enderecoEntityRecuperado.setEstado(enderecoDTO.getCidade());
        enderecoEntityRecuperado.setPais(enderecoDTO.getPais());
        enderecoEntityRecuperado.setComplemento(enderecoDTO.getComplemento());
        enderecoEntityRecuperado.setLogradouro(enderecoDTO.getLogradouro());
        enderecoEntityRecuperado.setNumero(enderecoDTO.getNumero());
        enderecoEntityRecuperado.setTipo(enderecoDTO.getTipo());

        return retornarDTO(enderecoRepository.save(enderecoEntityRecuperado));
    }


    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }


    public EnderecoEntity findById(Integer id) throws Exception {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public EnderecoEntity findByIdPessoa(Integer idPessoa) throws Exception {
        return enderecoRepository.findById(idPessoa)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public EnderecoEntity converterDTO(EnderecoCreateDTO dto) {
        return objectMapper.convertValue(dto, EnderecoEntity.class);
    }

    public EnderecoDTO retornarDTO(EnderecoEntity entity) {
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }
}
