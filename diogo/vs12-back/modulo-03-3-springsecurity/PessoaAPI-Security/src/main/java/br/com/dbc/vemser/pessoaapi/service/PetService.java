package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;

    private final String NOT_FOUND_MESSAGE = "ID do pet nao encontrado";


    public PetDTO create(Integer idPessoa, PetCreateDTO pet) throws Exception {
        PetEntity petEntity = converterDTO(pet);
        PessoaEntity pessoaEntity = pessoaService.findById(idPessoa);
        petEntity.setPessoaEntity(pessoaEntity);
        return retornarDTO(petRepository.save(petEntity));
    }

    public void delete(Integer id) throws Exception {
        try {
            PetEntity petEntityRecuperado = findById(id);
            petRepository.delete(petEntityRecuperado);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

    public PetDTO update(Integer id, PetCreateDTO petDTO) throws Exception {
        PetEntity petEntity = findById(id);

        petEntity.setTipoPet(petDTO.getTipoPet());
        petEntity.setNome(petDTO.getNome());

        return retornarDTO(petRepository.save(petEntity));
    }

    public List<PetDTO> list() {
        return petRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PetQueryDTO> getAllPetNames() {
        return petRepository.findAllPetNames();
    }


    public PetEntity findById(Integer id) throws Exception {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public PetEntity findByIdPessoa(PessoaEntity pessoa) throws Exception {
        return petRepository.findById(pessoa.getIdPessoa())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public PetEntity converterDTO(PetCreateDTO dto) {
        return objectMapper.convertValue(dto, PetEntity.class);
    }

    public PetDTO retornarDTO(PetEntity entity) {
        return objectMapper.convertValue(entity, PetDTO.class);
    }

}

