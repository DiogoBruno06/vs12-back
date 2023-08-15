package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.dto.dtosquery.PetQueryDTO;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<PetDTO> list() {
        return petService.list();
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                         @RequestBody PetCreateDTO petCreateDTO) throws Exception {
        return new ResponseEntity<>(petService.create(idPessoa, petCreateDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public PetDTO update(@PathVariable("id") Integer id,
                             @RequestBody PetCreateDTO petCreateDTO) throws Exception {
        return petService.update(id, petCreateDTO);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        petService.delete(id);
    }

    @GetMapping("/query-PET")
    public List<PetQueryDTO> petQuery() {
        return petService.getAllPetNames();
    }

}
