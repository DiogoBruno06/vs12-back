package com.br.dbc.produtorconsumidor.controller;


import com.br.dbc.produtorconsumidor.dto.MensagemDTO;
import com.br.dbc.produtorconsumidor.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/enviar")
    public void enviar(String mensagem){
        producerService.enviarMensagem(mensagem);
    }

    @PostMapping("/mensagem")
    public void enviarMensagem(@RequestBody MensagemDTO mensagemDTO, Integer particao) throws JsonProcessingException {
        producerService.enviarMensagem(mensagemDTO,particao);
    }
}
