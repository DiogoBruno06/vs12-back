package com.br.dbc.produtorconsumidor.service;

import com.br.dbc.produtorconsumidor.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    private final ObjectMapper objectMapper;
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})},
            clientIdPrefix = "geral"
    )
    public void consumeWhatsApp(@Payload String mensagem,
                                @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);

        LocalDateTime dataDaCriacao = mensagemDTO.getDataCriacao();
        String formatacaoData = dataDaCriacao.format(fmt);

        StringBuilder sb = new StringBuilder();
        sb.append(formatacaoData);
        sb.append("{" + mensagemDTO.getUsuario() + "}: ");
        sb.append(mensagemDTO.getMensagem());
        log.info(sb.toString());
    }

    @KafkaListener(
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"6"})},
            clientIdPrefix = "privado"
    )
    public void consumeWhatsAppPrivate(@Payload String mensagem,
                                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        LocalDateTime dataDaCriacao = mensagemDTO.getDataCriacao();
        String formatacaoData = dataDaCriacao.format(fmt);

        StringBuilder sb = new StringBuilder();
        sb.append(formatacaoData);
        sb.append("{ " + mensagemDTO.getUsuario() + "}(privado): ");
        sb.append(mensagemDTO.getMensagem());
        log.info(sb.toString());
    }
}
