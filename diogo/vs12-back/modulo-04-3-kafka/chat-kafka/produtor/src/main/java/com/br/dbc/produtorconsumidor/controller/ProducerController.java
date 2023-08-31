package com.br.dbc.produtorconsumidor.controller;


import com.br.dbc.produtorconsumidor.dto.EnvioEnum;
import com.br.dbc.produtorconsumidor.dto.MensagemDTO;
import com.br.dbc.produtorconsumidor.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/enviar-mensagem")
    private void enviar(String msg, @RequestParam("envios") List<EnvioEnum> envios) throws JsonProcessingException {
        for (EnvioEnum envioEnum : envios){
            MensagemDTO mensagemDTO = new MensagemDTO(String.valueOf(envioEnum.DIOGO), msg, LocalDateTime.now());
            producerService.sendMessage(mensagemDTO,envioEnum.ordinal());;
        }
    }
}
