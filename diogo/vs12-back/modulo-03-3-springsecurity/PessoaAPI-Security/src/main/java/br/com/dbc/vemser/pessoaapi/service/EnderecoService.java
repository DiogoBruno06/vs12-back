package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;
    private final EmailService emailService;
    private final PessoaRepository pessoaRepository;

    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";
    public void delete(Integer id) throws Exception {
        try {
            EnderecoEntity enderecoEntityRecuperado = findById(id);
            enderecoRepository.delete(enderecoEntityRecuperado);
            emailService.EnderecoDeletar();
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

    public EnderecoDTO create(Integer idPessoa,EnderecoCreateDTO endereco) throws Exception {
        EnderecoEntity enderecoEntity = converterDTO(endereco);
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        pessoaEntity.getEnderecos().add(enderecoEntity);
        pessoaRepository.save(pessoaEntity);
        emailService.EnderecoCriado(enderecoEntity.getIdEndereco());
        return retornarDTO(enderecoRepository.save(enderecoEntity));
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

        emailService.EnderecoEditado(enderecoEntityRecuperado.getIdEndereco());
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
    public List<EnderecoQueryDTO> findAllByCep() {
        return enderecoRepository.findAllByCep();
    }

}
