package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.ContatoQueryDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final ObjectMapper objectMapper;

    private final PessoaService pessoaService;


    private final String NOT_FOUND_MESSAGE = "ID do contato nao encontrada";


    public void delete(Integer id) throws Exception {
        try {
            ContatoEntity contatoEntityRecuperado = findById(id);
            contatoRepository.delete(contatoEntityRecuperado);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {
        ContatoEntity contatoEntity = converterDTO(contato);
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        contatoEntity.setPessoaEntity(pessoaEntity);
        return retornarDTO(contatoRepository.save(contatoEntity));
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoDto) throws Exception {
        ContatoEntity contatoEntityRecuperado = findById(id);

        contatoEntityRecuperado.setNumero(contatoDto.getNumero());
        contatoEntityRecuperado.setDescricao(contatoDto.getDescricao());
        contatoEntityRecuperado.setTipoContato(contatoDto.getTipoContato());

        return retornarDTO(contatoRepository.save(contatoEntityRecuperado));
    }


    public List<ContatoDTO> list() {
        return contatoRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public ContatoEntity findById(Integer id) throws Exception {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public List<ContatoQueryDTO> getAllByNumero() {
        return contatoRepository.findAllByNumero();
    }

    public ContatoEntity converterDTO(ContatoCreateDTO dto) {
        return objectMapper.convertValue(dto, ContatoEntity.class);
    }

    public ContatoDTO retornarDTO(ContatoEntity entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }



}