package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private Set<EnderecoEntity> enderecos;


    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL)
    private Set<ContatoEntity> contato;

    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL)
    private Set<PetEntity> pet;


//    public List<EnderecoEntity> getEnderecosById(Integer pessoaId) {
//        return enderecos.stream()
//                .filter(endereco -> endereco.getPessoas().stream()
//                        .anyMatch(pessoa -> pessoa.getIdPessoa().equals(pessoaId)))
//                .collect(Collectors.toList());
//    }


}