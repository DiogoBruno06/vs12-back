package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PET")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PET")
    @SequenceGenerator(name = "SEQ_PET", sequenceName = "seq_pet2", allocationSize = 1)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "NOME")
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoPet tipoPet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaEntity pessoaEntity;

}
