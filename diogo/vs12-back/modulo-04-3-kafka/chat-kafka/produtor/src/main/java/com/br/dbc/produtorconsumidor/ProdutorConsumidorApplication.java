package com.br.dbc.produtorconsumidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProdutorConsumidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutorConsumidorApplication.class, args);
	}

}
