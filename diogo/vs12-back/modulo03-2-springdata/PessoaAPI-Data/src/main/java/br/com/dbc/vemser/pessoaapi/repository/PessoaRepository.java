package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    @Query("SELECT p FROM PESSOA p WHERE (:idPessoa IS NULL OR p.idPessoa = :idPessoa)")
    List<PessoaEntity> findAllComOptional(@Param("idPessoa") Integer idPessoa);

    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO(p.idPessoa, p.nome, p.email) FROM PESSOA p")
    List<PessoaEmailDTO> findAllPessoaEmailDTO();
}

