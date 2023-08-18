package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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
        EnderecoEntity enderecoEntityRecuperado = enderecoRepository.getById(id);
        enderecoRepository.delete(enderecoEntityRecuperado);
        emailService.EnderecoDeletar();
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
        EnderecoEntity enderecoEntityRecuperado = enderecoRepository.getById(id);

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


    public EnderecoDTO getById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity endereco = enderecoRepository.getById(id);
        EnderecoDTO dto = objectMapper.convertValue(endereco,EnderecoDTO.class);
        return dto;
    }

    public List<EnderecoEntity> getByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        List<EnderecoEntity> endereco = enderecoRepository.findByPessoas_idPessoa(idPessoa);
        return endereco;
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
