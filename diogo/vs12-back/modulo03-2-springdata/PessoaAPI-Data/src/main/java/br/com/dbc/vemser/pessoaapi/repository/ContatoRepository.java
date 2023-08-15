package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.dtosquery.ContatoQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.dtosquery.ContatoQueryDTO(c.numero) FROM CONTATO c")
    List<ContatoQueryDTO> findAllByNumero();
}
