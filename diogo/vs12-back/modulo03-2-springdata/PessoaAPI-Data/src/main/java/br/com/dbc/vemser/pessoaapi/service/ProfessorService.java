package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_MESSAGE = "ID do contato nao encontrada";

    public ProfessorEntity create(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    public ProfessorEntity update(Integer id, ProfessorEntity professor, ProfessorPK professorPK) throws Exception {
        ProfessorEntity professorEntity = findById(professorPK);

        professorPK.setIdProfessor(professorPK.getIdProfessor());
        professorPK.setIdUniversidade(professorPK.getIdUniversidade());
        professorEntity.setProfessorPK(professorPK);
        professorEntity.setNome(professor.getNome());
        professorEntity.setSalario(professor.getSalario());

        return professorRepository.save(professorEntity);
    }

    public void delete(ProfessorPK professorPK) throws Exception {
        try {
            ProfessorEntity professorEntityRecuperado = findById(professorPK);
            professorRepository.delete(professorEntityRecuperado);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }



    public List<ProfessorEntity> list() {
        return professorRepository.findAll();
    }

    public ProfessorEntity findById(ProfessorPK professorPK) throws Exception {
        return professorRepository.getById(professorPK);
    }

}
