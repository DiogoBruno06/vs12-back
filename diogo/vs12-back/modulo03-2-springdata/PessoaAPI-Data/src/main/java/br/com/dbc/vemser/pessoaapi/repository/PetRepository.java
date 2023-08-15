package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetEntity,Integer> {
    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO(p.nome) FROM PET p")
    List<PetQueryDTO> findAllPetNames();
}
