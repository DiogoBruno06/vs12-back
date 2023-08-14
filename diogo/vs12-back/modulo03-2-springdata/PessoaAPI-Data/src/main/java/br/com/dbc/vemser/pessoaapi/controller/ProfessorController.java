package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }


    @GetMapping
    public List<ProfessorEntity> list() {
        return professorService.list();
    }

    @GetMapping("/{ProfessorPK}")
    public ResponseEntity<ProfessorEntity> listById(ProfessorPK professorPK) throws Exception {
        return new ResponseEntity<>(professorService.findById(professorPK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> create(
                                             @RequestBody ProfessorEntity professor) throws Exception {
        return new ResponseEntity<>(professorService.create(professor), HttpStatus.OK);
    }
}
