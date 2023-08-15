package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PessoaEmailDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.dtosquery.EnderecoQueryDTO(e.cep,e.cidade,e.estado,e.pais) FROM ENDERECO_PESSOA e")
    List<EnderecoQueryDTO> findAllByCep();
}

