package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    @Query("SELECT DISTINCT p FROM PESSOA p JOIN FETCH p.contato")
    List<PessoaEntity> findAllWithContatos();

    @Query("SELECT DISTINCT p FROM PESSOA p JOIN FETCH p.pet")
    List<PessoaEntity> findAllWithPet();
}

