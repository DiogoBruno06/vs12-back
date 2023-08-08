package br.com.dbc.vemser.pessoaapi;

import br.com.dbc.vemser.pessoaapi.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import javax.validation.constraints.Email;

@SpringBootTest
class PessoaApiApplicationTests {
	@Autowired
	private EmailService emailService;
	@Test
	void contextLoads() throws MessagingException {
		emailService.sendSimpleEmail();
	}

}
